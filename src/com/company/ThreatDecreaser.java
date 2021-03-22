package com.company;

public class ThreatDecreaser {
    //Sætter en specifik borgers trusselsniveau 1 ned
    public void Decrease(User user) {
        int threat = user.getThreatlevel();
        threat = threat - 1;
        user.setThreatlevel(threat);
    }
}
