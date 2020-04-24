package ru.dbi.restaurant.models;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String fileName = "DataProvider.txt";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Client id: " + this.id + '\n' + "First name: " + this.firstName + "\nLast name: " + this.lastName +
                '\n' + "Phone: " + this.phoneNumber;
    }

    public void createClient() throws Exception {
        //String fileName = "DataProvider.txt";
        File file = new File(fileName);
        if (file.length() != 0) {
            FileWriter fw = new FileWriter(file, true);
            fw.write('\n'+toString());
            fw.close();
            System.out.println("New Client has been added");
        } else {
            FileWriter fw = new FileWriter(file);
            fw.write(toString());
            fw.close();
            System.out.println("New Client has been added");
        }
    }

    public void readClient(String id) throws Exception {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            String text = null;
            while (scan.hasNextLine())
                text = text + scan.nextLine().toString() + '\n';
            text = text.substring(4);
            //System.out.println(text);
            String pattern = id;
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(text);
            if (m.find()) {
                int start = m.start();
                for (int i = start; i < text.length(); i++)
                    text = text.substring(start - 11);
            }
            System.out.println(text);
            String pattern1 = "Client id: ";
            String pattern2 = "\n";
            p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
            m = p.matcher(text);
            if (m.find())
                this.id = m.group(1);
            pattern1 = "First name: ";
            pattern2 = "\n";
            p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
            m = p.matcher(text);
            if (m.find())
                this.firstName = m.group(1);
            pattern1 = "Last name: ";
            pattern2 = "\n";
            p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
            m = p.matcher(text);
            if (m.find())
                this.lastName = m.group(1);
            pattern1 = "Phone: ";
            pattern2 = "\\$";
            p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
            m = p.matcher(text);
            if (m.find())
                this.phoneNumber = m.group(1);
            fr.close();
            System.out.println("You can work with a Client now");
        }
    }
//not working
    public void readAllClients(Client[] client) throws Exception {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            String text = null;
            while (scan.hasNextLine())
                //System.out.println(scan.nextLine());
                text = text + scan.nextLine().toString();
            System.out.println(text);
            while (!text.isEmpty()) {
                String pattern1 = "Client id:";
                String pattern2 = "First name";
                Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
                Matcher m = p.matcher(text);
                if (m.find())
                    this.id = m.group(1);
                pattern1 = "First name: ";
                pattern2 = "Last name";
                p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
                m = p.matcher(text);
                if (m.find())
                    this.firstName = m.group(1);
                pattern1 = "Last name: ";
                pattern2 = "Phone";
                p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
                m = p.matcher(text);
                if (m.find())
                    this.lastName = m.group(1);
                pattern1 = "Phone: ";
                pattern2 = "\\$";
                p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
                m = p.matcher(text);
                int end = 0;
                if (m.find()) {
                    this.phoneNumber = m.group(1);
                    end = m.end();
                }
                text = text.substring(end);
            }
            fr.close();
            System.out.println("You can work with a Client now");
        }
    }

    public void updateClient(String id, String field, String newField) throws Exception {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            String text = null;
            while (scan.hasNextLine())
                text = text + scan.nextLine().toString() + '\n';
            text = text.substring(4);
            String pattern = id;
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(text);
            if (m.find()) {
                int start = m.start();
                for (int i = start; i < text.length(); i++)
                    text = text.substring(start - 11);
            }
            switch (field) {
                case ("Client id"):
                    String pattern1 = "Client id: ";
                    String pattern2 = "\n";
                    Pattern p1 = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
                    Matcher m1 = p1.matcher(text);
                    if (m1.find())
                        text = m1.replaceFirst(pattern1 + newField + pattern2);
                    FileWriter fw1 = new FileWriter(file);
                    fw1.write(text);
                    fw1.close();
                    break;
                case ("First name"):
                    String pattern3 = "First name: ";
                    String pattern4 = "\n";
                    Pattern p2 = Pattern.compile(Pattern.quote(pattern3) + "(.*?)" + Pattern.quote(pattern4));
                    Matcher m2 = p2.matcher(text);
                    if (m2.find())
                        text = m2.replaceFirst(pattern3 + newField + pattern4);
                    FileWriter fw2 = new FileWriter(file);
                    fw2.write(text);
                    fw2.close();
                    break;
                case ("Last name"):
                    String pattern5 = "Last name: ";
                    String pattern6 = "\n";
                    Pattern p3 = Pattern.compile(Pattern.quote(pattern5) + "(.*?)" + Pattern.quote(pattern6));
                    Matcher m3 = p3.matcher(text);
                    if (m3.find())
                        text = m3.replaceFirst(pattern5 + newField + pattern6);
                    FileWriter fw3 = new FileWriter(file);
                    fw3.write(text);
                    fw3.close();
                    break;
                case ("Phone"):
                    String pattern7 = "Phone: ";
                    String pattern8 = "\\$";
                    Pattern p4 = Pattern.compile(Pattern.quote(pattern7) + "(.*?)" + Pattern.quote(pattern8));
                    Matcher m4 = p4.matcher(text);
                    if (m4.find())
                        text = m4.replaceFirst(pattern7 + newField + pattern8);
                    FileWriter fw4 = new FileWriter(file);
                    fw4.write(text);
                    fw4.close();
                    break;
            }
            fr.close();
        }
    }

    public void deleteClient(String id) throws Exception {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            String text = null;
            while (scan.hasNextLine())
                text = text + scan.nextLine().toString() + '\n';
            text = text.substring(4);
            String pattern = id;
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(text);
            String textToDel = null;
            int start = 0;
            if (m.find()) {
                start = m.start();
                for (int i = start; i < text.length(); i++)
                    textToDel = text.substring(start - 11);
                Scanner scanText = new Scanner(textToDel);
                String newText = null;
                int a = 0;
                for (int i = 0; i < 4; i++) {
                    newText = scanText.nextLine();
                    a = a + newText.length();
                }
                String needText = text.substring(0, start - 11) + text.substring(start-7+a);
                System.out.println(needText);
            FileWriter fw = new FileWriter(file);
            fw.write(needText);
            fw.close();
            fr.close();
                System.out.println("Client deleted");
            }
            else
                System.out.println("Client can't be found");

        }
    }
}
