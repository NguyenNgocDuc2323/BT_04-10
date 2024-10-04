package Controller;

import Entity.Staff;
import Service.StaffService;

import java.util.List;

public class StaffController {
    private List<Staff> staffs;
    private StaffService sv;
    public StaffController(StaffService sv) {
        this.sv = sv;
        this.staffs = sv.getStaffs();
    }
    public Staff getById(int id) {
        Staff staff = sv.getById(id);
        if(staff != null) {
            return staff;
        }
        return null;
    }
    public Staff getByCode(String code) {
        Staff staff = sv.getByCode(code);
        if(staff != null) {
            return staff;
        }
        return null;
    }
    public List<Staff> getByName(String name) {
        List<Staff> staffs = sv.getByName(name);
        if(staffs != null) {
            return staffs;
        }
        return null;
    }
}
