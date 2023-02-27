package src;

public class Resident extends Student {
    private int scholarship;
    private static final int residentTuition = 12536, creditHour = 404;

    public Resident(Profile givenProfile, Major givenMajor,
                    int givenCredits) {
        super(givenProfile, givenMajor, givenCredits);
        this.scholarship = 0;
    }

    public Resident(Profile givenProfile, Major givenMajor,
                    int givenCredits, int givenScholarship) {
        super(givenProfile, givenMajor, givenCredits);
        this.scholarship = givenScholarship;
    }

    public double tuitionDue(int creditsEnrolled) {
        double tuition;
        if (this.isFullTime()) { //full time student
            tuition = universityFee + residentTuition - scholarship;
            if (creditsEnrolled > creditHourLimit) {
                tuition += creditHour * (creditsEnrolled - creditHourLimit);
            }
        }
        else { //part time student
            tuition = (creditHour * creditsEnrolled)
                    + (percentFullTimeRate * residentTuition);
        }
        return tuition;
    }

    public boolean isResident() {
        return true;
    }

    public boolean isFullTime() {
        if (this.getCreditCompleted() >= 12)
            return true;
        return false;
    }
    public int getScholarship(){ return this.scholarship; }

    public void setScholarship(int givenScholarship) {
        this.scholarship += givenScholarship;
    }

    public String getClassification() {
        return "(resident)";
    }
    public String invalidStudent() {
        return "(Resident) ";
    }
}
