import java.io.StringWriter;

class Repere {
    EnsembleElementRepere elements;

    Repere() {
        elements = new EnsembleElementRepere();
    }

    void ajouter(ElementRepere e) {
        elements.ajouter(e);
    }

    public String toString() {
        StringWriter w = new StringWriter();
        w.append("Repere:\n");
        for (int i = 0; i < elements.taille(); i++) {
            w.append("\t" + elements.elements[i].toString() + "\n");
        }
        return w.toString();
    }
}