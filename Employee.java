

public class Employee {

  private String firstname;
  private String surname;
  private String telephone;
  private String email;
  private String id;
  private String trn;
  private String nisNum;
  private String bankAccountNum;
  private String employeeTier;
  private String dateOfEmployement;
  private String employementTermination;
  private String taxInformation;


  public Employee(String fname, String sname, String phone, String mail,
                  String idNum, String _trn, String _nisNum, String accountNum,
                  String tier, String employementDate, String taxInfo) {
    firstname = fname;
    surname = sname;
    telephone = phone;
    email = mail;
    id = idNum;
    trn = _trn;
    nisNum = _nisNum;
    bankAccountNum = accountNum;
    employeeTier = tier;
    dateOfEmployement = employementDate;
    taxInformation = taxInfo;
  }
}
