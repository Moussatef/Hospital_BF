package com.hospital.Impl;

import com.hospital.enumerations.InsuranceType;
import com.hospital.interfaces.PatientInterface;
import com.hospital.models.Doctor;
import com.hospital.models.Patient;
import com.hospital.models.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PatientImpl implements PatientInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public InsuranceType insuranceType(int chose) {

        switch (chose){
            case 1 : return InsuranceType.CNSS;

            case 2: return  InsuranceType.RAMED;
            case 3: return InsuranceType.CNOPS;
            case 4:return InsuranceType.NONE;
            default:
                System.out.println("This chose not in list");
                return null;
        }

    }
    @Override
    public Patient addPatient() {
        Patient p = new Patient();
        System.out.print("Entre first name :");
        p.setFirstname(scanner.next());
        System.out.print("Entre last name :");
        p.setLastname(scanner.next());
        System.out.print("Entre address :");
        p.setAddress(scanner.next());
        System.out.print("Entre phone number : +212-");
        p.setPhone(scanner.next());

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        p.setHospitalEntryDate(localDate);
        System.out.println("1 - "+InsuranceType.CNSS);
        System.out.println("2 - "+InsuranceType.RAMED);
        System.out.println("3 - "+InsuranceType.CNOPS);
        System.out.println("4 - "+InsuranceType.NONE);

        while (true){
            int chose = Integer.parseInt(scanner.next());
            if (chose >0 && chose<5){
                InsuranceType insuranceTypev = insuranceType(chose);
                p.setInsuranceType(insuranceTypev);
                break;
            }
        }
        LocalDateTime localDate1 = LocalDateTime.now();
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
        p.setAffiliationNumber(p.getFirstname().toUpperCase().charAt(0)+"_"+localDate1.format(dtf1));


        return p;

    }

    @Override
    public void showPatient(Patient p) {
        System.out.println(" patient number : "+p.getAffiliationNumber()+" Name : "+p.getFirstname()+" "+p.getLastname()+"date entre : "+p.getHospitalEntryDate()+" insurance type : "+p.getInsuranceType());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("\t\t patient number : "+p.getAffiliationNumber());
        System.out.println("\t\t Name : "+p.getFirstname()+" "+p.getLastname());
        System.out.println("\t\t Address : "+p.getAddress());
        System.out.println("\t\t Phone number : "+p.getPhone());
        System.out.println("\t\t Date entre : "+p.getHospitalEntryDate());
        System.out.println("\t\t Insurance type : "+p.getInsuranceType());
        System.out.println();

    }

    @Override
    public List<Patient> addListPatient() {
        String contenue;
        List<Patient> p = new ArrayList<>() ;
        do {
           p.add(addPatient());
            System.out.print("Do you want to add another patient (Y/N) :");
            contenue = scanner.next();

        }while (contenue.equalsIgnoreCase("Y"));
        return p;
    }

    @Override
    public void showListPatient(List<Patient> patients) {

        for (Patient p:patients){
            showPatient(p);
        }

    }
}
