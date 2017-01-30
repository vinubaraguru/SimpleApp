package com.vinu.epoise.ePoiseRecruiter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ePoise on 12/15/2016.
 */

public class TrainingAppliedCandidateList implements Serializable {

    @SerializedName("contacts")
    @Expose
    private ArrayList<Contact> contacts = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * @param contacts The contacts
     */
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public class Contact implements Serializable {
        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("address")
        @Expose
        private String address;

        @SerializedName("gender")
        @Expose
        private String gender;

        @SerializedName("profile_pic")
        @Expose
        private String profilePic;

        @SerializedName("phone")
        @Expose
        private Phone phone;

        /**
         * @return The id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The email
         */
        public String getEmail() {
            return email;
        }

        /**
         * @param email The email
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * @return The address
         */
        public String getAddress() {
            return address;
        }

        /**
         * @param address The address
         */
        public void setAddress(String address) {
            this.address = address;
        }

        /**
         * @return The gender
         */
        public String getGender() {
            return gender;
        }

        /**
         * @param gender The gender
         */
        public void setGender(String gender) {
            this.gender = gender;
        }

        /**
         * @return The profilePic
         */
        public String getProfilePic() {
            return profilePic;
        }

        /**
         * @param profilePic The profile_pic
         */
        public void setProfilePic(String profilePic) {
            this.profilePic = profilePic;
        }

        /**
         * @return The phone
         */
        public Phone getPhone() {
            return phone;
        }

        /**
         * @param phone The phone
         */
        public void setPhone(Phone phone) {
            this.phone = phone;
        }

        public class Phone {

            @SerializedName("mobile")
            @Expose
            private String mobile;

            @SerializedName("home")
            @Expose
            private String home;

            @SerializedName("office")
            @Expose
            private String office;

            /**
             * @return The mobile
             */
            public String getMobile() {
                return mobile;
            }

            /**
             * @param mobile The mobile
             */
            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            /**
             * @return The home
             */
            public String getHome() {
                return home;
            }

            /**
             * @param home The home
             */
            public void setHome(String home) {
                this.home = home;
            }

            /**
             * @return The office
             */
            public String getOffice() {
                return office;
            }

            /**
             * @param office The office
             */
            public void setOffice(String office) {
                this.office = office;
            }
        }
    }

//    private String trainingCandidateName;
//    private String trainingCandidateEmail;
//    private String trainingCandidateImage;
//
//    public TrainingAppliedCandidateList(String trainingCandidateName, String trainingCandidateEmail) {
//        this.trainingCandidateName = trainingCandidateName;
//        this.trainingCandidateEmail = trainingCandidateEmail;
//    }
//
//    public String getTrainingCandidateName() {
//        return trainingCandidateName;
//    }
//
//    public void setTrainingCandidateName(String trainingCandidateName) {
//        this.trainingCandidateName = trainingCandidateName;
//    }
//
//    public String getTrainingCandidateEmail() {
//        return trainingCandidateEmail;
//    }
//
//    public void setTrainingCandidateEmail(String trainingCandidateEmail) {
//        this.trainingCandidateEmail = trainingCandidateEmail;
//    }
//
//    public String getTrainingCandidateImage() {
//        return trainingCandidateImage;
//    }
//
//    public void setTrainingCandidateImage(String trainingCandidateImage) {
//        this.trainingCandidateImage = trainingCandidateImage;
//    }
}
