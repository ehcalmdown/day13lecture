package sg.edu.nus.iss.day13workshop.services;


import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DataBaseService {

    private File dataDir = new File("some directory");

    public File getDataDir(){
        return dataDir;
    }

    public void setDataDir(File dataDir){
        this.dataDir = dataDir;
    }
// /Users/<username/data
    // /home/data
public boolean isdDataDirValid(){
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
    }
    public boolean save() {
        return false;
    }

    public void read(String fileId){

    }

}
