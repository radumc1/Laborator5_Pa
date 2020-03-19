import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    //asemanator  cu metoda save citim din path si returnam un obiect de tip Catalog
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        InputStream fileIs = new FileInputStream(path);
        ObjectInputStream objIs = new ObjectInputStream(fileIs);
        Catalog emp = (Catalog) objIs.readObject();
        return emp;
    }

    // am luat uri ul din document cu ajutorul functie get apoi am testat daca clasa e suportata de platforma curenta dupa care am afisat cu .browse
    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        URI uri = new URI(doc.getLocation());
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        if (desktop != null) {
            desktop.browse(uri);
        }
    }
}
