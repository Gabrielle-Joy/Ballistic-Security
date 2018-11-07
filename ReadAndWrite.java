package mains;
import utils.*;
import lab3pkg.*;
import lab5pkg.*;

import java.util.*;
import java.io.*;

public class ReadAndWrite {

  // stores string array of each client in the file
  private ArrayList<String[]> accountData = new ArrayList<String[]>();
  // stores client objects created from the file
  private ArrayList<Client> clientInFileBefore = new ArrayList<Client>();

  private ArrayList<String[]> clientToPutInFile = new ArrayList<String[]>();

  private ArrayList<String[]> createdClient;

  private ArrayList<String[]> logOfDepositAndWithdraw = new ArrayList<String[]>();

  public ReadAndWrite() {
    }

  public void createClientFromFile(String filepath) {

    filepath = "data/new-clients.csv";

    // File log = new File(filepath);
    //
    try{
    //   if(!log.exists()){
    //     log.createNewFile();
    //   }

      String[] accountInfo = new String[]{};
      String[] ai;
      if (filepath.equals("")) {
        accountData = SimpleData.ReadCSV("data/new-clients.csv");
      } else {
        accountData = SimpleData.ReadCSV("data/new-clients.csv");

      }

      Client client;
      PersonalClient pc;
      BusinessClient bc = new BusinessClient("business", "GOO23", "Google Ltd.", "Serge Brim", "chequing", "486973233445.00", "Chudleigh District, Christiana", "Manchester", "1-876-444-3534");

      ArrayList<String> clientIdList = new ArrayList<String>();
      String clid;
      int clientIndex;
      for (int i=0; i<accountData.size(); i++ ) {

        if (i == 0) {
          continue;
        }

          // accountInfo = accountData.get(i);
          ai = accountData.get(i);
          // columns: 0-id, 1-name, 2-accType, 3-balance, 4-address, 5-parish, 6-phone

          clid = ai[1];
          clientIndex = clientIdList.indexOf(clid);
          if (clientIndex >= 0){

              client = clientInFileBefore.get(clientIndex);
              System.out.println("Found " + clid);
              Address addr = new Address(ai[5], ai[6]);


          } else {
              clientIndex = clientIdList.size();
              clientIdList.add(clid);
              if (ai[0].equalsIgnoreCase("business")) {
                try {
                  if (ai.length == 9) {
                    bc = new BusinessClient(ai[0], ai[1], ai[2], ai[3], ai[4], ai[5], ai[6], ai[7], ai[8]);
                    clientInFileBefore.add(bc);
                  } else {
                    bc = new BusinessClient(ai[0], ai[1], ai[2], ai[3], ai[4], ai[5], ai[6], ai[7], ai[8], ai[9]);
                    clientInFileBefore.add(bc);
                  }
                } catch (IllegalArgumentException iae) {
                  iae.printStackTrace();
                }
              } else {
                pc = new PersonalClient(ai[0], ai[1], ai[2], ai[3], ai[4], ai[5], ai[6], ai[7], ai[8], ai[9]);
                clientInFileBefore.add(pc);
              }
          }
          // c.addAccount(ai[2], Double.parseDouble(ai[3]));
      }

    } catch (IndexOutOfBoundsException iob) {
      iob.printStackTrace();
    } // catch (IOException ioe) {
    //   ioe.printStackTrace();
    // }
  }


  public void addClientToFileList(String[] clientInfo) {
    clientToPutInFile.add(clientInfo);
  }

  public void writeClientToFile() {
    SimpleData.writeCSV("data/new-clients.csv", clientToPutInFile);
  }

  public void writeClientToFile(String filepath) {
    SimpleData.writeCSV(filepath, clientToPutInFile);
  }

  public ArrayList<String[]> getStringArrayOfClientsFromFile() {
    return accountData;
  }

  public ArrayList<Client> getClientObjectCreatedFromFile() {
    return clientInFileBefore;
  }

  public void addToLogOfDepositAndWithdraw(String[] log) {
    logOfDepositAndWithdraw.add(log);
  }

  public void writeLogToFile() {
    SimpleData.writeCSV("data/log.csv", logOfDepositAndWithdraw);
  }

  public void writeLogToFile(String[] log) {
    SimpleData.writeCSV("data/log.csv", log);
  }

  public void writeCardToFile(ArrayList<String[]> cardInfo) {
    SimpleData.writeCSV("data/card.csv", cardInfo);
  }

}
