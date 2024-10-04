package Service;

import Entity.Staff;
import Global.Global;
import IGeneric.IGeneral;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StaffService implements IGeneral<Staff> {
    public List<Staff> staffs;
    public StaffService(List<Staff> staffs) {
        this.staffs = staffs;
    }
    @Override
    public Staff getById(int id) {
        Optional<Staff>filteredIdStaff = staffs.stream()
                .filter(staff -> staff.getId() == id)
                .findFirst();
        if(filteredIdStaff.isPresent()){
            return filteredIdStaff.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Staff getByCode(String code) {
        Optional<Staff> filteredCodeStaffs = staffs.stream()
                .filter(staff -> Global.ignoreCase(code,staff.getCode()))
                .findFirst();
        if(filteredCodeStaffs.isPresent()){
            return filteredCodeStaffs.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Staff> getByName(String keyword) {
        List<Staff> fillteredNameStaffs = staffs.stream()
                .filter(staff -> Global.ignoreCase(keyword,staff.getName()))
                .toList();
        if(fillteredNameStaffs.isEmpty()){
            return new ArrayList<>();
        }
        else{
            return fillteredNameStaffs;
        }
    }
    public List<Staff> getStaffs() {
        return staffs;
    }
}
