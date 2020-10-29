/*
Bank Application by Ritvik Kumar K 
IST 261 
Latest Update 10/29/20
 */

package bankapp.model;

import java.io.File;
import javax.swing.filechooser.FileFilter;


public class BofFilter extends FileFilter {

    public BofFilter() {
    }

    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".bof");
    }

    @Override
    public String getDescription() {
        return "Bank Object File";
    }

}
