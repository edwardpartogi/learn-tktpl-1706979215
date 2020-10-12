package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import java.util.Random;

public class PraisesCursesModel {
    private String name;
    private static String CURSE = "Curse you, ";
    private static String PRAISE = ", you are so cool!";

    public PraisesCursesModel(String newName) {
        name = newName;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        Random rand = new Random();
        if(rand.nextBoolean()) {
            return getPraised();
        }else {
            return getCursed();
        }
    }

    public String getCursed() {
        return CURSE+name+"!";
    }

    public String getPraised() {
        return name+PRAISE;
    }
}
