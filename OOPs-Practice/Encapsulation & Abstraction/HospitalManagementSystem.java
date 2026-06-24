// Abstract Class
abstract class Patient {

    // Private Fields
    private int patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract Method
    public abstract double calculateBill();

    // Concrete Method
    public void displayPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
    }
}

// InPatient Class
class InPatient extends Patient {

    private double roomCharges;
    private double treatmentCharges;

    public InPatient(int patientId, String name, int age,
                     double roomCharges, double treatmentCharges) {
        super(patientId, name, age);
        this.roomCharges = roomCharges;
        this.treatmentCharges = treatmentCharges;
    }

    public double getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

// OutPatient Class
class OutPatient extends Patient {

    private double consultationFees;
    private double treatmentCharges;

    public OutPatient(int patientId, String name, int age,
                      double consultationFees,
                      double treatmentCharges) {
        super(patientId, name, age);
        this.consultationFees = consultationFees;
        this.treatmentCharges = treatmentCharges;
    }

    public double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFees + treatmentCharges;
    }
}

// Main Class
public class HospitalManagementSystem {

    public static void main(String[] args) {

        InPatient inPatient = new InPatient(
                101,
                "Lav Kumar",
                22,
                10000,
                15000
        );

        OutPatient outPatient = new OutPatient(
                102,
                "Rahul Sharma",
                25,
                500,
                2500
        );

        System.out.println("===== In Patient Details =====");
        inPatient.displayPatientDetails();
        System.out.println("Total Bill : ₹"
                + inPatient.calculateBill());

        System.out.println();

        System.out.println("===== Out Patient Details =====");
        outPatient.displayPatientDetails();
        System.out.println("Total Bill : ₹"
                + outPatient.calculateBill());
    }
}