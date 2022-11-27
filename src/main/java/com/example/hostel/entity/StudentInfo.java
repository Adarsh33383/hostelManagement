package com.example.hostel.entity;

public class StudentInfo {

    private int StudentId;
    private String StudentName;
    private int RoomNo;
    private String Address;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int roomNo) {
        RoomNo = roomNo;
    }

    public StudentInfo(int studentId, String studentName, int roomNo, String address) {
        StudentId = studentId;
        StudentName = studentName;
        RoomNo = roomNo;
        Address = address;
    }

    public StudentInfo() {
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "StudentId=" + StudentId +
                ", StudentName='" + StudentName + '\'' +
                ", RoomNo=" + RoomNo +
                ", Address='" + Address + '\'' +
                '}';
    }
}
