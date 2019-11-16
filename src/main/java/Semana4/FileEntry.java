
package Semana4;

/**
 *
 * @author Carlos
 */
enum FileType{
    file,
    directory,
    systemFile,
    blank
}

public class FileEntry {
    
    protected String name;
    protected FileType type;
    protected int size; //Tamaño en bytes

    public FileEntry(){ 
        name = "UNKNOWN";
        type = FileType.blank;
        size = 0;
    }

    public FileEntry(String name, FileType type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }
    
    
    
    
    
    
}
