package com.example.hostel.entity;

public class StudentInfo {

    private int studentId;
    private String studentName;
    private int roomNo;
    private String address;

    private long phoneNumber;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StudentInfo() {
    }

    public StudentInfo(int studentId, String studentName, int roomNo, String address, long phoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.roomNo = roomNo;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", roomNo=" + roomNo +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
