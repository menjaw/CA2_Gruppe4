package service.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import service.entity.Address;
import service.entity.CityInfo;
import service.entity.Hobby;
import service.entity.InfoEntity;
import service.entity.Person;
import service.entity.Phone;

/**
 *
 * @author Group 4
 */
public class DataGenerator {
    String fileNameToCreate = "dataForDatabase.txt";
    static int productionCount = 3;
    Random r = new Random();
    String nameOfTable = "";
    
    public void generateCityinfo(int noOfRecordsToProduce){
        WriteFile data = new WriteFile(fileNameToCreate, true);//initiate filewriter with the given filename and text append boolean values
        List<CityInfo> dataList = new ArrayList(); 
        int count = 0;
        nameOfTable = "CITYINFO";
        for (int i = 0; i < noOfRecordsToProduce; i++) {
            CityInfo dataElement = new CityInfo(count+1, "city"+(count+1));
            dataList.add(dataElement);
            String result = "insert into "+nameOfTable+" (zipcode, city) values ("+dataElement.getZipCode()+", \""+dataElement.getCity()+"\");";
            data.writeToFile(result);
            count++;
        }
        for (CityInfo dataElement : dataList) {
            System.out.println(dataElement);
        }
    }
    
    public void generateHobby(int noOfRecordsToProduce){
        WriteFile data = new WriteFile(fileNameToCreate, true);//initiate filewriter with the given filename and text append boolean values
        List<Hobby> dataList = new ArrayList(); 
        int count = 0;
        nameOfTable = "HOBBY";
        for (int i = 0; i < noOfRecordsToProduce; i++) {
            Hobby dataElement = new Hobby("hobbyName"+(count+1), "hobbyDescription"+(count+1));
            dataList.add(dataElement);
            String result = "insert into "+nameOfTable+" (`name`, description) values ("+"\""+dataElement.getName()+"\", \""+dataElement.getDescription()+"\");";
            data.writeToFile(result);
            count++;
        }
        for (Hobby dataElement : dataList) {
            System.out.println(dataElement);
        }
    }
    
     public void generateAddress(int noOfRecordsToProduce){
        WriteFile data = new WriteFile(fileNameToCreate, true);//initiate filewriter with the given filename and text append boolean values
        List<Address> dataList = new ArrayList(); 
        int count = 0;
        nameOfTable = "ADDRESS";
        for (int i = 0; i < noOfRecordsToProduce; i++) {
            Address dataElement = new Address("street"+(count+1), "additionalInfo"+(count+1));
            dataList.add(dataElement);
            String result = "insert into "+nameOfTable+" (street, additionalInfo, CITYINFO_zipcode) values (\""+dataElement.getStreet()+"\", \""+dataElement.getAdditionalInfo()+"\", "+(count+1)+");";
            data.writeToFile(result);
            count++;
        }
        for (Address dataElement : dataList) {
            System.out.println(dataElement);
        }
    }
     
    public void generateInfoentity(int noOfRecordsToProduce){
        WriteFile data = new WriteFile(fileNameToCreate, true);//initiate filewriter with the given filename and text append boolean values
        List<InfoEntity> dataList = new ArrayList(); 
        int count = 0;
        nameOfTable = "INFOENTITY";
        for (int i = 0; i < noOfRecordsToProduce; i++) {
            InfoEntity dataElement = new InfoEntity((count+1)+"@email.com");
            dataList.add(dataElement);
            String result = "insert into "+nameOfTable+" (dtype, email, address_id) values (\"Person\", \""+dataElement.getEmail()+"\", "+(count+1)+");";
            data.writeToFile(result);
            count++;
        }
        for (InfoEntity dataElement : dataList) {
            System.out.println(dataElement);
        }
    }
    
    public void generatePerson(int noOfRecordsToProduce){
        WriteFile data = new WriteFile(fileNameToCreate, true);//initiate filewriter with the given filename and text append boolean values
        List<Person> dataList = new ArrayList(); 
        int count = 0;
        nameOfTable = "PERSON";
        for (int i = 0; i < noOfRecordsToProduce; i++) {
            Person dataElement = new Person("fn"+(count+1),"ln"+(count+1),"em"+(count+1));
            dataList.add(dataElement);
//            String result = "insert into "+nameOfTable+" (firstname, lastname) values (\""+dataElement.getFirstName()+"\", \""+dataElement.getLastName()+"\");";
            String result = "insert into "+nameOfTable+" (id, firstname, lastname) values ("+(count+1)+", \""+dataElement.getFirstName()+"\", \""+dataElement.getLastName()+"\");";
            data.writeToFile(result);
            count++;
        }
        for (Person dataElement : dataList) {
            System.out.println(dataElement);
        }
    }
    
    public void generatePerson_hobby(int noOfRecordsToProduce){
        WriteFile data = new WriteFile(fileNameToCreate, true);//initiate filewriter with the given filename and text append boolean values
        int count = 0;
        nameOfTable = "PERSON_HOBBY";
        for (int i = 0; i < noOfRecordsToProduce; i++) {
            String result = "insert into "+nameOfTable+" (hobbies_id, person_id) values ("+(count+1)+", "+(count+1)+");";
            data.writeToFile(result);
            count++;
        }
    }
    
     public void generatePhone(int noOfRecordsToProduce){
        WriteFile data = new WriteFile(fileNameToCreate, true);//initiate filewriter with the given filename and text append boolean values
        List<Phone> dataList = new ArrayList(); 
        int count = 0;
        nameOfTable = "PHONE";
        for (int i = 0; i < noOfRecordsToProduce; i++) {
            Phone dataElement = new Phone(count+1,"phoneDescription"+(count+1));
            dataList.add(dataElement);
            String result = "insert into "+nameOfTable+" (id, number, description, ie_id) values ("+(count+1)+", "+dataElement.getNumber()+", \""+dataElement.getDescription()+"\", "+(count+1)+");";
            data.writeToFile(result);
            count++;
        }
        for (Phone dataElement : dataList) {
            System.out.println(dataElement);
        }
    }
     
    public static void main(String[] args) {
        DataGenerator dg = new DataGenerator();
        dg.generateCityinfo(productionCount);
        dg.generateHobby(productionCount);
        dg.generateAddress(productionCount);
        dg.generateInfoentity(productionCount);
        dg.generatePerson(productionCount);
        dg.generatePerson_hobby(productionCount);
        dg.generatePhone(productionCount);
    }
}