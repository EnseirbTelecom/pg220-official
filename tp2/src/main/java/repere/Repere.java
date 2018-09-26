package repere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import repere.formes.Cercle;
import repere.formes.Point;
import repere.formes.Segment;
import repere.formes.Triangle;

public class Repere {

	private String titre;
	
	private Set<ElementRepere> elements;

	private Axe x;

	private Axe y;

	public Repere(String titre, Axe x, Axe y) {
		this.titre = titre;
		this.x = x;
		this.y = y;
		this.elements = new HashSet<ElementRepere>();
	}

	public Repere(Reader reader) {
		try {
			String couleurDef = "\\[(\\d+),(\\d+),(\\d+)\\]";
			
			Pattern repere = Pattern.compile("Repere (.*)");
			Pattern axe = Pattern.compile(String.format("Axe (\\d+) %s (.*)", couleurDef));
			Pattern point = Pattern.compile(String.format("Point \\((\\d+),(\\d+)\\) %s", couleurDef));
			Pattern segment = Pattern.compile(String.format("Segment %s %s %s", couleurDef, point, point));
			Pattern cercle = Pattern.compile(String.format("Cercle (\\d+) %s %s", couleurDef, point));
			Pattern triangle = Pattern.compile(String.format("Triangle %s %s %s %s", couleurDef, point, point, point));
			
			BufferedReader r = new BufferedReader(reader);
			
			Matcher repereDef = repere.matcher(r.readLine());
			Matcher xDef = axe.matcher(r.readLine());
			Matcher yDef = axe.matcher(r.readLine());
			
			repereDef.matches();
			this.titre = repereDef.group(1);
			xDef.matches();
			this.x = new Axe(couleurPourMatcher(xDef, 2), xDef.group(5), Integer.parseInt(xDef.group(1)));
			yDef.matches();
			this.y = new Axe(couleurPourMatcher(yDef, 2), yDef.group(5), Integer.parseInt(yDef.group(1)));
			this.elements = new HashSet<ElementRepere>();
			
			String line;
			while ((line = r.readLine()) != null) {
				if (line.charAt(0) == 'P') {
					Matcher pDef = point.matcher(line);
					pDef.matches();
					ajouter(pointPourMatcher(pDef, 1));
				} else if (line.charAt(0) == 'S') {
					Matcher sDef = segment.matcher(line);
					sDef.matches();
					Segment s = new Segment(couleurPourMatcher(sDef, 1), pointPourMatcher(sDef, 4),
							pointPourMatcher(sDef, 9));
					ajouter(s);
				} else if (line.charAt(0) == 'C') {
					Matcher cDef = cercle.matcher(line);
					cDef.matches();
					Cercle c = new Cercle(couleurPourMatcher(cDef, 2), pointPourMatcher(cDef, 5), 
							Integer.parseInt(cDef.group(1)));
					ajouter(c);
				} else if (line.charAt(0) == 'T') {
					Matcher tDef = triangle.matcher(line);
					tDef.matches();
					Triangle t = new Triangle(couleurPourMatcher(tDef, 1), pointPourMatcher(tDef, 4),
							pointPourMatcher(tDef, 9), pointPourMatcher(tDef, 14));
					ajouter(t);
				}
			}
			
			r.close();

		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	private Couleur couleurPourMatcher(Matcher def, int offset) {
		return new Couleur(Integer.parseInt(def.group(offset)), Integer.parseInt(def.group(offset + 1)), 
				Integer.parseInt(def.group(offset + 2)));
	}
	
	private Point pointPourMatcher(Matcher def, int offset) {
		return new Point(couleurPourMatcher(def, offset + 2), Integer.parseInt(def.group(offset)), 
				Integer.parseInt(def.group(offset + 1)));
	}
	
	public Axe getX() {
		return x;
	}

	public Axe getY() {
		return y;
	}
	
	public String getTitre() {
		return this.titre;
	}

	public void ajouter(ElementRepere e) {
		try {
			if (e.validePour(this))
				elements.add(e);
		} catch (ElementInvalide err) {
			System.err.println(err);
		}
	}
	
	Set<ElementRepere> getElements() {
		return elements;
	}

	public void sauvegarder(Writer w) {
		try {
			w.append(String.format("Repere %s\n", titre));
			w.append(String.format("%s\n", x.serialisation()));
			w.append(String.format("%s\n", y.serialisation()));
			for (ElementRepere e: elements)
				w.append(String.format("%s\n", e.serialisation()));
			w.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dessiner(Writer w) {
		try {
			w.append("<?xml version='1.0' encoding='utf-8'?>\n");
			w.append(String.format("<svg xmlns='http://www.w3.org/2000/svg' version='1.1' width='%d' height='%d'>\n", x.getTaille() * 10, y.getTaille() * 10));
			w.append(String.format("<line x1='0' y1='0' x2='%d' y2='0' style='stroke:%s;stroke-width:3' />\n", x.getTaille() * 10, x.getCouleur().svg()));
			w.append(String.format("<line x1='0' y1='0' y2='%d' x2='0' style='stroke:%s;stroke-width:3' />\n", y.getTaille() * 10, y.getCouleur().svg()));
			for( ElementRepere e: elements )
				w.append(String.format("%s\n", e.svg()));
			w.append("</svg>");
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
