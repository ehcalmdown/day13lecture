package sg.edu.nus.iss.day13workshop.services;


import org.springframework.stereotype.Service;
import sg.edu.nus.iss.day13workshop.models.Contact;

import java.io.*;
import java.util.Scanner;

@Service
public class DataBaseService {

    private File dataDir = new File("./data");

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
    public boolean save(final Contact contact) {
        File f = new File(this.dataDir, contact.getId());
        //return false;
        try(OutputStream out = new FileOutputStream(f)){
            PrintWriter pw = new PrintWriter(out);
            pw.println(contact.getId());
            pw.println(contact.getName());
            pw.println(contact.getEmail());
            pw.println(contact.getPhone());
            pw.flush();
            return true;
        }catch(IOException ex){
            System.err.println("Error:" + ex.getMessage());
            //ex.printStackTrace();
            return false;
        }
        //return false;
    }

    public Contact read(String fileId){
        try{
            File f = new File(this.dataDir, fileId);
            Scanner myReader = new Scanner(f);
            while(myReader.hasNextLine()){
                System.out.println(myReader.nextLine());


            }
            myReader.close();
            Contact contact = new Contact();
            return contact;
        }catch(IOException ex){
            System.err.println("Error " + ex.getMessage());
            ex.printStackTrace();
            return null;

        }

    }

}
