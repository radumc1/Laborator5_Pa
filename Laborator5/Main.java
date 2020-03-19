import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        try {
            app.testCreateSave();
            app.testLoadView();
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("Java Resources", "e:/baza/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, URISyntaxException, ClassNotFoundException {
        Catalog catalog = CatalogUtil.load("e:/baza/catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }


}