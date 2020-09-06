package nix.jdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Account {

    private Long id;
    private Long userId;
    private Long currency;

    public Account(Long id, Long userId, Long currency){
        this.id = id;
        this.userId = userId;
        this.currency = currency;
    }

    public Account(){}

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCurrency() {
        return currency;
    }

//    public Map<Integer, Integer> getData(DbConnection db){
//        int counter=0;
//        try{
//            ResultSet result = db.getAmountOfLocations();
//            while (true) {
//                try {
//                    if (!result.next()) break;
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                counter = result.getInt("id");
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//
//
//        int [][] values = new int [counter][counter];
//        for(int i=0; i<counter; i++){
//            for(int j=0; j<counter; j++){
//                values[i][j] = 0;
//            }
//        }
//
//        try{
//            int i=0; int j =0;
//            ResultSet result = db.getRoute();
//            while (true) {
//                try {
//                    if (!result.next()) break;
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                i = result.getInt("from_id");
//                j = result.getInt("to_id");
//                values[i-1][j-1] = result.getInt("cost");
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//
//
//        int id=0; int start =0; int end =0; int tempResult=0;
//        Map<Integer, Integer> map = new HashMap<>();
//        try{
//            ResultSet result = db.getProblems();
//            while (true) {
//                try {
//                    if (!result.next()) break;
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                id = result.getInt("id");
//                start = result.getInt("from_id");
//                end = result.getInt("to_id");
//
//                tempResult = FindTheCheapestWay.task((start-1), (end-1), values);
//                map.put(id, tempResult);
//
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        return map;
//    }
}
