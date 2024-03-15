package bo.custom;


import dto.AdminDto;

import java.sql.SQLException;
import java.util.List;

public interface AdminBo {

    List<AdminDto> getAllAdmins() throws SQLException;

    AdminDto getAdminByEmail(String userName) throws  SQLException;

    AdminDto getUserById(int id) throws SQLException;

    void updateAdmin(AdminDto dto) throws SQLException;

    void saveAdmin(AdminDto adminDto) throws SQLException, ClassNotFoundException;

    void deleteAdmin(int id) throws SQLException;

    AdminDto getAdminById(int adminId) throws SQLException;
}