package bo.impl;



import bo.custom.AdminBo;
import dao.custom.AdminDao;
import dao.util.DaoFactory;
import dto.AdminDto;
import etntity.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminBoImpl implements AdminBo {
    private AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ADMIN);

    @Override
    public List<AdminDto> getAllAdmins() throws SQLException {
        List<Admin> entities = adminDao.loadAll();
        List<AdminDto> dtos = new ArrayList<>();
        for (Admin admin : entities){
            dtos.add(new AdminDto(admin.getName(), admin.getEmail(), admin.getUserName(), admin.getPassword()));
        }
        return  dtos;

    }

    @Override
    public AdminDto getAdminByEmail(String userName) throws SQLException {
        Admin admin = adminDao.get(userName);
        return new AdminDto(admin.getAdminId(), admin.getName(), admin.getEmail(),admin.getUserName(),admin.getPassword());
    }

    @Override
    public AdminDto getUserById(int id) throws SQLException {
        Admin admin = adminDao.getbyId(id);
        System.out.println(id);
        return new AdminDto(admin.getAdminId(), admin.getName(), admin.getEmail(), admin.getUserName(), admin.getPassword());
    }

    @Override
    public void updateAdmin(AdminDto dto) throws SQLException {
        adminDao.update(new Admin(dto.getAdminId(), dto.getName(), dto.getPassword(), dto.getUserName(), dto.getEmail()));

    }

    @Override
    public void saveAdmin(AdminDto adminDto) throws SQLException, ClassNotFoundException {
           adminDao.save(new Admin( adminDto.getEmail(), adminDto.getName(), adminDto.getPassword(), adminDto.getUserName() ));
    }

    @Override
    public void deleteAdmin(int id) throws SQLException {
        adminDao.delete(id);

    }

    @Override
    public AdminDto getAdminById(int adminId) throws SQLException {
       Admin admin = adminDao.getbyId(adminId);
       return new AdminDto(admin.getAdminId(), admin.getName(), admin.getEmail(), admin.getUserName(), admin.getPassword());
    }
}
