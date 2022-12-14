package an.poliakov.task3;

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {
    private String [] exts;

    public MyFilter(String [] exts) {
        this.exts = exts;
    }

    //метод вызывается для каждой папки/файла
    //если true - этот обьект добавляется в наш итоговый list
    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()){
            return false;
        }

        //получаем расширение файла (только его и ничего лишнего)
        String extension = getExtension(pathname);

        for (String e : exts){
            if(extension.equalsIgnoreCase(e)){
                return true;
            }
        }

        return false;
    }

    //метод отвечающий за получение расшерения из указанного файла
    private String getExtension(File file){
        String ext = null;
        String fullPath = file.getPath();
        int indexPoint = fullPath.lastIndexOf(".");

        if((indexPoint != -1) && (indexPoint < fullPath.length()-1)){
            ext = fullPath.substring(indexPoint + 1).toLowerCase();
        }
        return ext;
    }
}
