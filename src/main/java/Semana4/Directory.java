/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana4;
import java.util.ArrayList;
/**
 *
 * @author Carlos
 */
public class Directory extends FileEntry{
    private ArrayList<FileEntry> listFiles; 

    public Directory( String name, FileType type, int size) {
        super(name, type, size);
        this.listFiles = new ArrayList<FileEntry>();
    }

    public ArrayList<FileEntry> getListFiles() {
        return listFiles;
    }
    
    public void addDirectory(String nombre,int tamaño){
        listFiles.add(new Directory(nombre,FileType.directory,tamaño));
        
    }
    
    public void addFile(String nombre, String ext, int tamaño){
        listFiles.add(new File(ext,nombre,FileType.file,tamaño));
    }

    
}
