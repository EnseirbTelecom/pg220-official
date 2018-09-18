import java.lang.reflect.Method;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		performSteps();
	}

	public static void checkStep1() {
		category("Couleur");
		Couleur c1 = new Couleur();
		assertTrue("Constructeur Couleur sans paramètre", c1.getR() == 0 && c1.getG() == 0 && c1.getB() == 0);
		Couleur c2 = new Couleur(10, 10, 10);
		assertTrue("Constructeur Couleur avec paramètres", c2.getR() == 10 && c2.getG() == 10 && c2.getB() == 10);
		assertTrue("Couleur toString", new Couleur().toString().equals("couleur : (0,0,0)"));
		assertTrue("Couleur ROUGE statique", Couleur.ROUGE.getR() == 255 && Couleur.ROUGE.getG() == 0 && Couleur.ROUGE.getB() == 0);
		Couleur r = Couleur.auHasard();
		assertTrue("Couleur au hasard", r != null);
	}

	public static void checkStep2() {
		category("ElementAvecNom");
		ElementAvecNom e1 = new ElementAvecNom();
		assertTrue("Constructeur ElementAvecNom sans paramètre: titre", e1.getTitre().equals(""));
		ElementAvecNom e2 = new ElementAvecNom("element");
		assertTrue("Constructeur ElementAvecNom avec paramètres: titre", e2.getTitre().equals("element"));
		assertTrue("ElementAvecNom toString: titre", e2.toString().equals("titre : element"));

		category("Axe");
		assertTrue("Héritage Axe ElementAvecNom", Axe.class.getSuperclass().equals(ElementAvecNom.class));
		Axe axe1 = new Axe();
		assertTrue("Constructeur Axe sans paramètre: taille", axe1.getTaille() == 10);
		assertTrue("Constructeur Axe sans paramètre: titre", axe1.getTitre() == "");
		Axe axe2 = new Axe("axe", 5);
		assertTrue("Constructeur Axe avec paramètres: taille", axe2.getTaille() == 5);
		assertTrue("Constructeur Axe avec paramètres: titre", axe2.getTitre().equals("AXE"));
		assertTrue("Axe toString: titre", axe2.toString().equals("Axe taille : 5, titre : AXE"));
	}

	public static void checkStep3() {
		category("ElementRepere");
		assertTrue("Héritage Axe ElementAvecNom", ElementRepere.class.getSuperclass().equals(ElementAvecNom.class));
		ElementRepere e1 = new ElementRepere();
		assertTrue("Constructeur ElementRepere sans paramètre: couleur", e1.getCouleur().getR() == 0 && e1.getCouleur().getG() == 0 && e1.getCouleur().getB() == 0);
		Couleur c = new Couleur();
		ElementRepere e2 = new ElementRepere("element", c);
		assertTrue("Constructeur ElementRepere avec paramètres: couleur", e2.getCouleur() == c);
		assertTrue("ElementRepere toString", e2.toString().equals("couleur : (0,0,0), titre : element"));

		category("Point");
		assertTrue("Héritage Point ElementRepere", Point.class.getSuperclass().equals(ElementRepere.class));
		Point p1 = new Point();
		assertTrue("Constructeur Point sans paramètre", p1.getX() == 0 && p1.getY() == 0);
		Point p2 = new Point("point", c, 10, 10);
		assertTrue("Constructeur Point avec paramètres", p2.getX() == 10 && p2.getY() == 10);
		assertTrue("Point toString", p2.toString() .equals("Point (10,10), couleur : (0,0,0), titre : point"));
		assertTrue("Point equals", new Point().equals(new Point()));

		category("Droite");
		assertTrue("Héritage Droite ElementRepere", Droite.class.getSuperclass().equals(ElementRepere.class));
		Droite d1 = new Droite();
		assertTrue("Constructeur Droite sans paramètre", d1.getOrigine().getX() == 0 && d1.getOrigine().getY() == 0 && d1.getDestination().getX() == 1 && d1.getDestination().getY() == 1);
		Droite d2 = new Droite("droite", c, p1, p2);
		assertTrue("Constructeur Droite avec paramètres", d2.getOrigine() == p1 && d2.getDestination() == p2);
		assertTrue("Droite toString", d2.toString() .equals("Droite (0,0) -> (10,10), couleur : (0,0,0), titre : droite"));
		assertTrue("Droite equals", new Droite().equals(new Droite()));
	}

	public static void checkStep4() {
		category("EnsembleElementRepere");
		EnsembleElementRepere ens = new EnsembleElementRepere();
		assertTrue("EnsembleElementRepere taille 0", ens.taille() == 0);
		Point p = new Point();
		ens.ajouter(p);
		assertTrue("EnsembleElementRepere taille 1", ens.taille() == 1);
		assertTrue("EnsembleElementRepere element 1", ens.elements()[0] == p);
		Point doublon = new Point();
		ens.ajouter(doublon);
		assertTrue("EnsembleElementRepere taille doublon", ens.taille() == 1);
		Droite d = new Droite();
		ens.ajouter(d);
		assertTrue("EnsembleElementRepere taille 2", ens.taille() == 2);
		assertTrue("EnsembleElementRepere element 2", ens.elements()[1] == d);
		Couleur c = new Couleur();
		for (int i = 2; i < 50000; i++ ) {
			ens.ajouter(new Point("point", c, i, i));
		}
		assertTrue("EnsembleElementRepere taille 50000", ens.taille() == 50000);
		assertTrue("EnsembleElementRepere element 50000", ((Point) ens.elements()[50000 - 1]).getX() == 50000 - 1);

		category("Repere");
		Repere r = new Repere();
		r.ajouter(p);
		r.ajouter(d);
		assertTrue("Repere toString", r.toString().split("[\n\t]").length == 5);
	}

	private static void performSteps() throws Exception {
		Method[] methods = Main.class.getDeclaredMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("checkStep")) {
				step(m.getName());
				long tic = System.currentTimeMillis();
				m.invoke(null);
				long duration = System.currentTimeMillis() - tic;
				step(String.format("%s executed in %d ms\n", m.getName(), duration));
			}
		}
	}

	private static void step(String step) {
		System.out.println(String.format("%s%s%s", ANSI_BLUE, step, ANSI_RESET));
	}

	private static void category(String category) {
		System.out.println("\t" + category);
	}

	private static void passed(String msg) {
		System.out.println(String.format("\t\t%s%s %s%s", ANSI_GREEN, UNICODE_CHECKMARK, msg, ANSI_RESET));
	}

	private static void failed(String msg) {
		System.out.println(String.format("\t\t%s%s %s%s", ANSI_RED, UNICODE_CROSSMARK, msg, ANSI_RESET));
	}

	private static void assertTrue(String msg, boolean bool) {
		if (bool) {
			passed(msg);
		} else {
			failed(msg);
		}
	}

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String UNICODE_CHECKMARK = "\u2713";
	private static final String UNICODE_CROSSMARK = "\u2717";
}
