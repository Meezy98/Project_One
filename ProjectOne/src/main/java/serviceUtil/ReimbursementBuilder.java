package serviceUtil;

import Controller.util.models.LoginReceived;
import Driver.Testing;
import daolayer.DAOQueries;
import daolayer.Reimbursements;
import daolayer.UserSpecs;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ReimbursementBuilder {
    Date myDate = java.sql.Date.valueOf(getDate());

    private final String APPROVED = "Approved";
    private final String DENIED = "Denied";
    ReimbursementBuilder builder;
    private Reimbursements reimbursements;

    private StringBuilder idGenerator(String pool, int idLength) {
        StringBuilder returnedID = new StringBuilder();


        Random randomGen = new Random();
        char[] idChar = new char[idLength];
        for (int i = 0; i < idLength; i++) {
            idChar[i] = pool.charAt(randomGen.nextInt(pool.length()));
        }
        for (char c : idChar) {
            returnedID.append(c);
        }
        return returnedID;
    }

    public StringBuilder idBuilder() {
        builder = new ReimbursementBuilder();
        StringBuilder firstTwo = builder.idGenerator("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 2);
        StringBuilder twoNums = builder.idGenerator("0123456789", 2);
        StringBuilder lastTwo = builder.idGenerator("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 2);
        return firstTwo.append(twoNums).append(lastTwo);
    }

    public LocalDate getDate() {
        return LocalDate.now();

    }

    public Reimbursements passStringForID(String variable) {
        return new Reimbursements(variable,
                "",
                null,
                0,
                "",
                "");
    }
    public List<UserSpecs> validateUser(UserSpecs specs){

        UserSpecs userSpecs = new UserSpecs();
        userSpecs.setUserLogin(specs.getUserLogin());
        userSpecs.setUserPass(specs.getUserPass());
        return new DAOQueries().validateUser(userSpecs);

    }
    public  List<Reimbursements> requestsByUserService(Reimbursements reimbursements){
        Reimbursements requests = new Reimbursements();
        requests.setSubmittedBy(reimbursements.getSubmittedBy());
        return new DAOQueries().returnRequestsByLogin(requests);
    }
    public Reimbursements passStringForStatus(String variable) {

        return new Reimbursements("",
                "",
                null,
                0,
                "",
                "s"
        );
    }
    public List<Reimbursements> sortByStatus(){
        List<Reimbursements> reimbursementsList = new DAOQueries().returnRequests();
        reimbursementsList.sort(Comparator.comparing(Reimbursements::getStatus));
        return reimbursementsList;
    }
    public List<Reimbursements> sortByDate(){
        List<Reimbursements> reimbursementsList = new DAOQueries().returnRequests();
        reimbursementsList.sort(Comparator.comparing(Reimbursements::getSubmittedDate));
        return reimbursementsList;
    }
    public List<Reimbursements> sortByUser(){
        List<Reimbursements> reimbursementsList = new DAOQueries().returnRequests();
        reimbursementsList.sort(Comparator.comparing(Reimbursements::getSubmittedBy));
//        reimbursementsList.sort((r1,r2)-> r1.getSubmittedBy() - (r2.getSubmittedBy()));
        return reimbursementsList;
    }
//    public List<Reimbursements> returnMaster(){
//
//    }
    public void newRequestService(Reimbursements reimbursements){
    String id =String.valueOf(idBuilder());
    String PENDING = "Pending";
    Date myDate = java.sql.Date.valueOf(getDate());
    reimbursements = new Reimbursements(id,"iamthelaw420", myDate, reimbursements.getRequestAmount(), reimbursements.getReason(), PENDING);
       new DAOQueries().newRequest(reimbursements);

    }
    public void deleteRequestService(Reimbursements reimbursements){
        Date myDate = java.sql.Date.valueOf(getDate());
        reimbursements = new Reimbursements(reimbursements.getRequestID(), "iamthelaw420",
                myDate, reimbursements.getRequestAmount(), reimbursements.getReason(), "PENDING");
        new DAOQueries().deleteRequest(reimbursements);
    }
    public void updateRequestService(Reimbursements reimbursements){
        reimbursements = new Reimbursements(reimbursements.getRequestID(), "",
                myDate, 0, "", reimbursements.getStatus());
       new DAOQueries().updateRequest(reimbursements);

    }

}