package com.polytech.covid.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.covid.Model.Admin;
import com.polytech.covid.Model.Center;
import com.polytech.covid.Model.Doctor;
import com.polytech.covid.Model.Reservation;
import com.polytech.covid.Repository.CenterRepository;
//import com.polytech.covid.Repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CenterService {
    
    
    private final CenterRepository centerRepository;

    private final VilleService villeService;

    private final AdminService adminService;

    private final DoctorService doctorService;

    //private final ReservationRepository reservationRepository;

    public void create(Center centre){
        centerRepository.save(centre);
    }

    public List<Center> getAllCenters(){
        return centerRepository.findAll();
    }

    public List<Center> getCentersByTown(Long id){
        return villeService.getCenters(id);
    }

    public Center getById(Long id){
        return centerRepository.findById(id).get();
    }

    public Admin getAdmin(Center centre){
        return centre.getAdmin();
    }

    public Admin getAdminByCenterId(Long id){
        return getAdmin(getById(id));
    }

    public List<Reservation> reservations(Long id){
        //return reservationRepository.findAllByCenterId(centre.getId());
        return getById(id).getReservations();
    }

    public Center update(Long id, Center newCenter){
        return centerRepository.findById(id).map(center -> {
            if(newCenter.getName()!=null)center.setName(newCenter.getName());
            if(newCenter.getVille()!=null)center.setVille(newCenter.getVille());
            if(newCenter.getAdmin()!=null)center.setAdmin(newCenter.getAdmin());
            return centerRepository.save(center);
        }).orElseThrow();
    }

    public void delete(Long id){
        centerRepository.deleteById(id);
    }

    public Admin updateAdmin(Long id, Admin newAdmin){
        Admin admin = getAdminByCenterId(id);
        return adminService.update(admin.getId(), newAdmin);
    }

    public List<Doctor> getDoctors(Long centerId){
        return getById(centerId).getDoctors();
    }

    public Center addDoctor(Long centerId, Doctor doctor){
        return centerRepository.findById(centerId).map(center -> {
            List<Doctor> doctors = center.getDoctors();
            doctorService.save(doctor);
            doctors.add(doctor);
            center.setDoctors(doctors);
            return centerRepository.save(center);
        }).orElseThrow();
    }

    public Center deleteDoctor(Long centerId, Long doctorId){
        return centerRepository.findById(centerId).map(center -> {
            List<Doctor> doctors = center.getDoctors();
            doctors.remove(doctorService.getDoctorById(doctorId));
            doctorService.delete(doctorId);
            center.setDoctors(doctors);
            return centerRepository.save(center);
        }).orElseThrow();
    }

    public List<Reservation> getReservations(Long centerId){
        return getById(centerId).getReservations();
    }
}
