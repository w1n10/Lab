package Controller;

import model.Doctor;
import View.Menu;
import java.util.ArrayList;

public class DoctorManager {

    private Menu menu;
    private ArrayList<Doctor> doctorList;

    public DoctorManager() {
        menu = new Menu("Doctor Management System", new String[]{
            "Add doctor",
            "Update doctor",
            "Delete doctor",
            "Search doctor",
            "Exit"
        });
        doctorList = new ArrayList<>();
    }

    public void run() {
        while (true) {
            int choice = menu.getSelectedChoice();
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void addDoctor() {
        String code = menu.getInputString("Enter code: ");
        if (isCodeExists(code)) {
            menu.showMessage("Code already exists.");
            return;
        }
        String name = menu.getInputString("Enter name: ");
        String specialization = menu.getInputString("Enter specialization: ");
        int availability = menu.getInputInt("Enter availability: ");
        doctorList.add(new Doctor(code, name, specialization, availability));
        menu.showMessage("Doctor added successfully.");
    }

    private void updateDoctor() {
        String code = menu.getInputString("Enter code: ");
        Doctor doctorToUpdate = getDoctorByCode(code);
        if (doctorToUpdate == null) {
            menu.showMessage("Doctor not found.");
            return;
        }
        String newName = menu.getInputString("Enter new name: ");
        String newSpecialization = menu.getInputString("Enter new specialization: ");
        int newAvailability = menu.getInputInt("Enter new availability: ");
        doctorToUpdate.setName(newName);
        doctorToUpdate.setSpecialization(newSpecialization);
        doctorToUpdate.setAvailability(newAvailability);
        menu.showMessage("Doctor updated successfully.");
    }

    private void deleteDoctor() {
        String code = menu.getInputString("Enter code: ");
        Doctor doctorToDelete = getDoctorByCode(code);
        if (doctorToDelete == null) {
            menu.showMessage("Doctor not found.");
            return;
        }
        doctorList.remove(doctorToDelete);
        menu.showMessage("Doctor deleted successfully.");
    }

    private void searchDoctor() {
        String nameToSearch = menu.getInputString("Enter name to search: ");
        ArrayList<Doctor> foundDoctors = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            if (doctor.getName().equalsIgnoreCase(nameToSearch)) {
                foundDoctors.add(doctor);
            }
        }
        if (foundDoctors.isEmpty()) {
            menu.showMessage("No doctor found with that name.");
        } else {
            menu.showMessage("Found doctors:");
            for (Doctor doctor : foundDoctors) {
                menu.showMessage(doctor.toString());
            }
        }
    }

    private boolean isCodeExists(String code) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    private Doctor getDoctorByCode(String code) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }
}