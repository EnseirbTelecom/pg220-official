# TP 2

L’objectif de ce TP est de programmer une bibliothèque complète qui permet de créer des repères comportant plusieurs types d'éléments (segments, points, cercles et triangles). Il est demandé de maximiser la réutilisation de code grâce à l’utilisation du polymorphisme et les redéfinitions de méthodes.
Ce TP doit être réalisé avec l'IDE Eclipse. La première étape est d'importer le code de [test](src/test/java) dans votre projet.

## Structure du programme

![Structure du programme](doc/design.png)

## Fonctionnalités

La spécification ci-dessous décrit les fonctionnalités du programme à implémenter. N'oubliez pas d'aller lentement et de lancer régulièrement tous les tests relatifs au code que vous écrivez.

### Création des éléments du repère (moyen)

Vous devez vérifier que les éléments de repère créés sont conformes. Pour éviter la création d'objets non conformes, vous devez renvoyer un objet d'erreur instance de [`IllegalArgumentException`](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/IllegalArgumentException.html) (une erreur qui provient de la librairie standard et qui indique que la valeur d'un paramètre n'est pas correcte).

Voici la description des cas de non conformité pour les différents éléments:

* Un point est non conforme si et seulement si au moins une de ses deux coordonées sont négatives.
* Un segment est non conforme si et seulement si ses points de départ et d'arrivée sont équivalents.
* Un cercle est non conforme si et seulement si son rayon est négatif, nul, ou qu'un des points situés sur le cercle est non conforme.
* Un triangle est non conforme si il existe un couple de point équivalents dans ses points de définition. En outre, il ne faut pas que les trois points soient alignés.

### Gestion du repère (moyen)

L'ajout d'un élément repère qui n'est pas contenu dans le repère doit lever une exception de type `HorsRepereException`. Pour cela, vous devez vous aider de la méthode abstraite `boolean validePour(Repere r)` définie dans `ElementRepere`. Voici la description des cas d'invalidité pour les différents éléments :

* Un point est valide si et seulement si ses coordonnées sont inférieures ou égales aux tailles des axes du repère.
* Un segment est valide si et seulement si ses points de départ et d'arrivée sont valides.
* Un cercle est valide si et seulement si tous les points situés sur le cercle sont valides.
* Un triangle est valide si et seulement si tous ses points sont valides.

Enfin si un élement repère équivalent est déjà présent dans le repère, il ne doit pas être ajouté (mais sans levée d'exception). Des éléments sont considérés équivalents si ils ont des coordonnées équivalentes (par contre, les couleurs ne sont pas prises en compte). Attention, des éléments qui sont équivalents à une permutation près de leurs coordonnées sont aussi équivalents. Par exemple le segment (0,0) -> (1,1) est équivalent au segment (1,1) -> (0,0). Pour assurer cette contrainte vous devez utiliser une collection de type [`Set`](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/HashSet.html) de la librarie standard de Java. Vous devez ainsi gérer l'équivalence en utilisant les méthodes [`public boolean equals(Object o)`](https://docs.oracle.com/javase/8/docs/api/java/util/Objects.html#equals-java.lang.Object-java.lang.Object-) et [`public int hashCode()`](https://docs.oracle.com/javase/8/docs/api/java/util/Objects.html#hashCode-java.lang.Object-).

### Gestion de la sérialisation (difficile)

Vous devez permettre de charger/sauvegarder le contenu du repère depuis un fichier avec la syntaxe suivante :

~~~ java
Repere titre
Axe 10 [255,255,255] titre
Axe 10 [255,255,255] titre
Point (0,0) [0,255,0]
Point (3,6) [0,255,0]
Point (2,2) [0,255,0]
Segment [0,255,0] Point (3,3) [0,255,0] Point (6,6) [0,255,0]
Segment [0,255,0] Point (1,1) [0,255,0] Point (5,5) [0,255,0]
Cercle 2 [0,0,255] Point (2,2) [0,0,255]
Triangle [0,0,255] Point (1,1) [0,0,255] Point (2,1) [0,0,255] Point (2,2) [0,0,255]
~~~

La première ligne configure le repère, la seconde l’axe des abscisses, la troisième l’axe des ordonnées et les lignes suivantes ajoutent des points, des segments, des cercles, des triangles. Pour `Couleur`, les composantes RGB sont passées de cette manière: `[R,G,B]`. Pour `Point`, les coordonnées sont passées de cette manière `(x,y)`. Pour les segments, cercles et triangles, les arguments de l'élément sont passés en premier, puis ensuite les points qui les composent dans l'ordre suivant:

* Pour `Segment`, le premier point est origine le deuxième est destination
* Pour `Cercle` le point fourni correspond au centre
* Pour `Triangle`, le premier point est point1, le deuxième point est point2 et le troisième est point3.

Implémentez cette fonctionnalité à l'aide de la méthode statique `Repere charger(Reader reader)`, de la méthode `void sauvegarder(Writer writer)` et de la méthode abstraite `String serialisation()` de la classe `ElementRepere`.

### Export en SVG (difficile)

Implémentez la méthode `void dessiner(Writer writer)` dans la classe `Repere` qui permet de sauvegarder la description du repère, au format [SVG](http://fr.wikipedia.org/wiki/Scalable_Vector_Graphics). Le fichier de sortie est spécifié à la création de l'objet de type Writer. Pour implémenter cette méthode, il faut vous aider d'une méthode abstraite `String svg()` dans la classe `ElementRepere` qui sera redéfinie.
