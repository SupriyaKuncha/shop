package com.onlinebookshop.shop.model;

public class Book {
private int id;
private String title;
private double price;
private int authorId;
public Book(int id, String title,int authorId, double price) {
	super();
	this.id = id;
	this.title = title;
	this.price = price;
	this.authorId = authorId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String gettitle() {
	return title;
}
public void settitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getAuthorId() {
	return authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", price=" + price + ", authorId=" + authorId + "]";
}


}
