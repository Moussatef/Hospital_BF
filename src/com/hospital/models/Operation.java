package com.hospital.models;

import com.hospital.enumerations.StatuType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operation {
    private String codeOperation;
    private String description ;
    private float price;
    private LocalDateTime dateTimeOperation;

    private Doctor doctor;
    private Patient patient;
    private Hospital hospital;
    private Room room;
    private StatuType statu;

    public  Operation(){}

    public Operation(String description,float price,LocalDateTime dateTimeOperation,Doctor doctor,Patient patient, Hospital hospital,Room room){
        this.setCodeOperation(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"))+"_"+ (Math.random() *(100)));
        this.setDescription(description);
        this.setPrice(price);
        this.setDateTimeOperation(dateTimeOperation);
        this.setDoctor(doctor);
        this.setPatient(patient);
        this.setHospital(hospital);
        this.setRoom(room);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getDateTimeOperation() {
        return dateTimeOperation;
    }

    public void setDateTimeOperation(LocalDateTime dateTimeOperation) {
        this.dateTimeOperation = dateTimeOperation;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public StatuType getStatu() {
        return statu;
    }

    public void setStatu(StatuType statu) {
        this.statu = statu;
    }

    public String getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(String codeOperation) {
        this.codeOperation = codeOperation;
    }


    // Une op�ration sera dans un hopital dans une salle sp�cifique et g�r� par un m�decin X qui fait partie de l'hopital :)

	
	// Il faut v�rifier l'assurance du patient avant de passer l'op�ration
	
	// Ajouter une classe infirmi�re pour aider le m�decin dans son travail
	
	// l'assurance rembourse un pourcentage de 70% si c'est CNSS et 80% pour RAMED et 100% pour CNOPS 
	
	// chaque op�ration a un prix, le patient doit payer le montant et apr�s l'hopital va lui remboursser (le cas du CNSS et CNOPS) , si RAMED le patient va juste 
	// payer la diff�rence d�s le d�but (20%)
	
	// Proposition : Ajouter un attribut portefeuille � la classe Patient pour g�rer le solde du patient, et du coup il faut avoir aussi une classe transaction qui tra�e les 
	// actions de payments avec la date...
	
	// Essayer de structurer votre travail avec la cr�ation des interfaces qui vous permettez d'impl�menter les m�thodes n�cessaires.
	
	// Apr�s le payement d'une op�ration et si c'est pass� avec succ�s le programme est termin�, sinon il faut renvoyer le montant vers la portefeuille patient
	// et dans ce cas son dossier est en stand by pour le discuter au tribunal. (vous devez g�rer les status de chaque op�ration)
}