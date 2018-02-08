public class Magazine implements IDedObject {

    private int magazineID;
    private String magazineName;
    private String publisherName;

    public Magazine(int id, String name, String publisher)
    {
        magazineID = id;
        magazineName = name;
        publisherName = publisher;
    }

    public void setID(int id)
    {
        magazineID = id;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    @Override
    public int getID() {
        return magazineID;
    }

    @Override
    public void printID() {
        System.out.println("The Magazine name is: " + magazineName + ".");
        System.out.println("The ID of the magazine is: " + magazineID + ".");
        System.out.println("The publisher of the magazine is: " + publisherName + ".");
    }
}
