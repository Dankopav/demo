package hr.danko.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danko on 5/1/2017.
 */
public class ContactDAOImpl implements ContactDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Override
    public void saveOrUpdateContact(Contact contact) {
        if (contact.getId() > 0) {
            // update
            String sql = "UPDATE CONTACTS SET FIRSTNAME=?, LASTNAME=?, MAILADDRESS=?,VALIDSTATUS=? WHERE ID=?";
            jdbcTemplate.update(sql, contact.getFirstName(),contact.getLastName(),contact.getMailAddress(),
                    contact.getValidStatus());
        } else {
            // insert
            String sql = "INSERT INTO CONTACTS(FIRSTNAME, LASTNAME,MAILADDRESS,VALIDSTATUS)"
                    + " VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql,contact.getFirstName(),contact.getLastName(),contact.getMailAddress(),contact.getValidStatus());
        }
    }
    @Override
    public void deleteContact(int id) {
        //delete
        String sql="DELETE FROM CONTACTS WHERE ID=?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public Contact getContact(int id) {
        String sql = "SELECT * FROM CONTACTS WHERE ID=" + id;
        jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {
            @Override
            public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    Contact contact = new Contact();
                    contact.setId(rs.getInt("ID"));
                    contact.setFirstName(rs.getString("FIRSTNAME"));
                    contact.setLastName(rs.getString("LASTNAME"));
                    contact.setValidStatus(rs.getString("VALIDSTATUS"));
                    return contact;
                }
               return null;
            }
        });
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        String sql = "SELECT * FROM contact";
        List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contact aContact = new Contact();

                aContact.setId(rs.getInt("ID"));
                aContact.setFirstName(rs.getString("FIRSTNAME"));
                aContact.setLastName(rs.getString("LASTNAME"));
                aContact.setMailAddress(rs.getString("MAILADDRESS"));
                aContact.setValidStatus(rs.getString("VALIDSTATUS"));
                return aContact;
            }
        });
        return listContact;
    }
}


