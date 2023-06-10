package ru.netology.shop;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String s){
        super(s);
    }
}
