package com.wsy;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;

import com.wsy.iframe.BookAddIFrame;
import com.wsy.iframe.BookBackIFrame;
import com.wsy.iframe.BookBorrowIFrame;
import com.wsy.iframe.BookModiAndDelIFrame;
import com.wsy.iframe.BookSearchIFrame;
import com.wsy.iframe.BookTypeAddIFrame;
import com.wsy.iframe.BookTypeModiAndDelIFrame;
import com.wsy.iframe.GengGaiMiMa;
import com.wsy.iframe.ReaderAddIFrame;
import com.wsy.iframe.ReaderModiAndDelIFrame;
import com.wsy.iframe.UserAddIFrame;
import com.wsy.iframe.UserModiAndDelIFrame;
import com.wsy.iframe.newBookCheckIFrame;
import com.wsy.iframe.newBookOrderIFrame;
import com.wsy.util.*;
/**
 * 
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; 

	public static PasswordModiAction MODIFY_PASSWORD; 
	public static UserModiAction USER_MODIFY; 
	public static UserAddAction USER_ADD; 
	public static BookSearchAction BOOK_SEARCH; 
	public static GiveBackAction GIVE_BACK;
	public static BorrowAction BORROW; 
	public static CheckAndAcceptNewBookAction NEWBOOK_CHECK_ACCEPT;
	public static BoodOrderAction NEWBOOK_ORDER; 
	public static BookTypeModiAction BOOKTYPE_MODIFY; 
	public static BookTypeAddAction BOOKTYPE_ADD; 
	public static ReaderModiAction READER_MODIFY; 
	public static ReaderAddAction READER_ADD; 
	public static BookModiAction BOOK_MODIFY; 
	public static BookAddAction BOOK_ADD; 
	public static ExitAction EXIT; 

	static {
		frames = new HashMap<String, JInternalFrame>();

		MODIFY_PASSWORD = new PasswordModiAction();
		USER_MODIFY = new UserModiAction();
		USER_ADD = new UserAddAction();
		BOOK_SEARCH = new BookSearchAction();
		GIVE_BACK = new GiveBackAction();
		BORROW = new BorrowAction();
		NEWBOOK_CHECK_ACCEPT = new CheckAndAcceptNewBookAction();
		NEWBOOK_ORDER = new BoodOrderAction();
		BOOKTYPE_MODIFY = new BookTypeModiAction();
		BOOKTYPE_ADD = new BookTypeAddAction();
		READER_MODIFY = new ReaderModiAction();
		READER_ADD = new ReaderAddAction();
		BOOK_MODIFY = new BookModiAction();
		BOOK_ADD = new BookAddAction();
		EXIT = new ExitAction();
	}

	private static class PasswordModiAction extends AbstractAction {
		PasswordModiAction() {
			putValue(Action.NAME,"Change Password");
			putValue(Action.LONG_DESCRIPTION, "Modify the current password");
			putValue(Action.SHORT_DESCRIPTION, "Change Password");
			//putValue(Action.SMALL_ICON,CreatecdIcon.add("bookAddtb.jpg"));
			
			//setEnabled(false);
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Change Password")||frames.get("Change Password").isClosed()) {
				GengGaiMiMa iframe=new GengGaiMiMa();
				frames.put("Change Password", iframe);
				Library.addIFame(frames.get("Change Password"));
			}
		}
	}

	private static class UserModiAction extends AbstractAction {
		UserModiAction() {
			super("User Modify or Delete", null);
			putValue(Action.LONG_DESCRIPTION, "Modify or delete userinfo.");
			putValue(Action.SHORT_DESCRIPTION, "User Modify or Delete");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Modify or delete userinfo.")||frames.get("Modify or delete userinfo.").isClosed()) {
				UserModiAndDelIFrame iframe=new UserModiAndDelIFrame();
				frames.put("Modify or delete userinfo.", iframe);
				Library.addIFame(frames.get("Modify or delete userinfo."));
			}
		}
	}

	private static class UserAddAction extends AbstractAction {
		UserAddAction() {
			super("Add User", null);
			putValue(Action.LONG_DESCRIPTION, "Add New User");
			putValue(Action.SHORT_DESCRIPTION, "Add User");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Add Userinfo.")||frames.get("Add Userinfo.").isClosed()) {
				UserAddIFrame iframe=new UserAddIFrame();
				frames.put("Add Userinfo.", iframe);
				Library.addIFame(frames.get("Add Userinfo."));
			}
			
		}
	}

	private static class BookSearchAction extends AbstractAction {
		BookSearchAction() {
			super("Search Book", null);
			putValue(Action.LONG_DESCRIPTION, "Search the Bookinfo.");
			putValue(Action.SHORT_DESCRIPTION, "Search Book");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Search Book")||frames.get("Search Book").isClosed()) {
				BookSearchIFrame iframe=new BookSearchIFrame();
				frames.put("Search Book", iframe);
				Library.addIFame(frames.get("Search Book"));
			}
		}
	}

	private static class GiveBackAction extends AbstractAction {
		GiveBackAction() {
			super("Return Book", null);
			putValue(Action.LONG_DESCRIPTION, "¹é»¹½èÔÄµÄÍ¼Êé");
			putValue(Action.SHORT_DESCRIPTION, "Return Book");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Book Returning Management")||frames.get("Book Returning Management").isClosed()) {
				BookBackIFrame iframe=new BookBackIFrame();
				frames.put("Book Returning Management", iframe);
				Library.addIFame(frames.get("Book Returning Management"));
			}
		}
	}

	private static class BorrowAction extends AbstractAction {
		BorrowAction() {
			super("Borrowing Book", null);
			putValue(Action.LONG_DESCRIPTION, "Borrow Book from the library");
			putValue(Action.SHORT_DESCRIPTION, "Borrowing Book");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Borrowing Book Management")||frames.get("Borrowing Book Management").isClosed()) {
				BookBorrowIFrame iframe=new BookBorrowIFrame();
				frames.put("Borrowing Book Management", iframe);
				Library.addIFame(frames.get("Borrowing Book Management"));
			}
		}
	}

	private static class CheckAndAcceptNewBookAction extends AbstractAction {
		CheckAndAcceptNewBookAction() {
			super("Check Book", null);
			putValue(Action.LONG_DESCRIPTION, "Check the New Book");
			putValue(Action.SHORT_DESCRIPTION, "Check Book");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("Check Book")||frames.get("Check Book").isClosed()) {
				newBookCheckIFrame iframe=new newBookCheckIFrame();
				frames.put("Check Book", iframe);
				Library.addIFame(frames.get("Check Book"));
			}
		}
	}

	private static class BoodOrderAction extends AbstractAction {
		BoodOrderAction() {
			super("Order Book", null);
			putValue(Action.LONG_DESCRIPTION, "Order the New Book");
			putValue(Action.SHORT_DESCRIPTION, "Order Book");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("Book Ordering Management")||frames.get("Book Ordering Management").isClosed()) {
				newBookOrderIFrame iframe=new newBookOrderIFrame();
				frames.put("Book Ordering Management", iframe);
				Library.addIFame(frames.get("Book Ordering Management"));
			}
		}
	}

	private static class BookTypeModiAction extends AbstractAction {
		BookTypeModiAction() {
			super("Booktype Modify", null);
			putValue(Action.LONG_DESCRIPTION, "Modify the Bookinfo.");
			putValue(Action.SHORT_DESCRIPTION, "Booktype Modify");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Booktype Modify")||frames.get("Booktype Modify").isClosed()) {
				BookTypeModiAndDelIFrame iframe=new BookTypeModiAndDelIFrame();
				frames.put("Booktype Modify", iframe);
				Library.addIFame(frames.get("Booktype Modify"));
			}
		}
	}

	private static class BookTypeAddAction extends AbstractAction {
		BookTypeAddAction() {
			super("Add Booktype", null);
			putValue(Action.LONG_DESCRIPTION, "Add Booktype for your library");
			putValue(Action.SHORT_DESCRIPTION, "Add Booktype");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Add Booktype")||frames.get("Add Booktype").isClosed()) {
				BookTypeAddIFrame iframe=new BookTypeAddIFrame();
				frames.put("Add Booktype", iframe);
				Library.addIFame(frames.get("Add Booktype"));
			}
		}
	}
	private static class ReaderModiAction extends AbstractAction {
		ReaderModiAction() {
			super("Reader Modify and Delete", null);
			putValue(Action.LONG_DESCRIPTION, "Modify and Delete the Reader Basic info.");
			putValue(Action.SHORT_DESCRIPTION, "Reader Modify and Delete");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (!frames.containsKey("Reader Modify and Delete")||frames.get("Reader Modify and Delete").isClosed()) {
				ReaderModiAndDelIFrame iframe=new ReaderModiAndDelIFrame();
				frames.put("Reader Modify and Delete", iframe);
				Library.addIFame(frames.get("Reader Modify and Delete"));
			}
		}
	}

	private static class ReaderAddAction extends AbstractAction {
		ReaderAddAction() {
			super("Add Readerinfo.", null);
			putValue(Action.LONG_DESCRIPTION, "Add Readerinfo. for the library");
			putValue(Action.SHORT_DESCRIPTION, "Add Readerinfo.");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Add Readerinfo.")||frames.get("Add Readerinfo.").isClosed()) {
				ReaderAddIFrame iframe=new ReaderAddIFrame();
				frames.put("Add Readerinfo.", iframe);
				Library.addIFame(frames.get("Add Readerinfo."));
			}
		}
	}
	
	private static class BookModiAction extends AbstractAction {
		BookModiAction() {
			super("Modify the Book", null);
			putValue(Action.LONG_DESCRIPTION, "Modify and Delete the Bookinfo.");
			putValue(Action.SHORT_DESCRIPTION, "Modify the Book");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Modify the Book")||frames.get("Modify the Book").isClosed()) {
				BookModiAndDelIFrame iframe=new BookModiAndDelIFrame();
				frames.put("Modify the Book", iframe);
				Library.addIFame(frames.get("Modify the Book"));
			}
		}
	}
	private static class BookAddAction extends AbstractAction {				
		BookAddAction() {

			super("Add Bookinfo.", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "Add Bookinfo. for the library");
			putValue(Action.SHORT_DESCRIPTION, "Add Bookinfo.");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("Add Bookinfo.")||frames.get("Add Bookinfo.").isClosed()) {
				BookAddIFrame iframe = new BookAddIFrame();
				frames.put("Add Bookinfo.", iframe);
				Library.addIFame(frames.get("Add Bookinfo."));
			}
		}
	}
	private static class ExitAction extends AbstractAction { 
		public ExitAction() {
			super("Exit", null);
			putValue(Action.LONG_DESCRIPTION, "Exit the library System");
			putValue(Action.SHORT_DESCRIPTION, "Exit");
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}

}
