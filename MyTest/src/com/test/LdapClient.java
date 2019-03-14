package com.test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LdapClient {
	
	public static void main(String[] args) {
		LdapClient ldap = new LdapClient();
		DirContext dirContext = null;
		try {
			dirContext = ldap.connect("localhost", "389", "cn=Manager,dc=maxcrc,dc=com", "cn=Manager,dc=maxcrc,dc=com", "secret");
//			BasicAttributes basicattributes = new BasicAttributes(true); // case-ignore
//		    Attribute objclass = new BasicAttribute("objectclass");
//		    objclass.add("top");
//		    objclass.add("organizationalUnit");
//		    basicattributes.put(objclass);
//			
//			ldap.createTest(dirContext, basicattributes, "ou=NewOu");
			// Check that it was created by listing its parent
			
			
			SearchControls constraints = new SearchControls();
            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		    NamingEnumeration<NameClassPair> list = dirContext.list("dc=maxcrc,dc=com");

		    // Go through each item in list
			while (list.hasMore()) {
				NameClassPair nc = (NameClassPair) list.next();
				System.out.println(nc);
			}
			System.out.println("Connection establishment success");
		} catch (NamingException e) {
			e.printStackTrace();
		} finally{
			ldap.disconnect(dirContext);
		}
	}

	/**
	 * Connect to server.
	 */
	public DirContext connect(String host, String port, String rootdn, String username, String password)
			throws NamingException {
		Hashtable<String, String> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://" + host + ":" + port + "/" + rootdn);
		env.put(Context.REFERRAL, "throw");
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.SECURITY_PRINCIPAL, username);
		DirContext dirContext = new InitialDirContext(env);
		return dirContext;
	}

	/**
	 * Disconnect from the server.
	 */
	public void disconnect(DirContext dirContext) {
		try {
			if (dirContext != null) {
				dirContext.close();
				dirContext = null;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Filter the data in the ldap directory for the given search base.
	 * 
	 * @param searchBase where the search should start
	 * @param searchFilter filter this value from the base
	 */
	public boolean searchTest(DirContext dirContext, String searchBase, String searchFilter) throws NamingException {
		System.out.println("Base=" + searchBase + " Filter=" + searchFilter);
		SearchControls searchcontrols = new SearchControls(SearchControls.SUBTREE_SCOPE, 1L, // count
																								// //
																								// limit
				0, // time limit
				null, // attributes (null = all)
				false, // return object ?
				false);// dereference links?
		NamingEnumeration<SearchResult> ne = dirContext.search(searchBase, searchFilter, searchcontrols);
		System.out.println("Loop " + ne.toString() + " " + ne.hasMore());
		while (ne.hasMore()) {
			Object tmp = ne.next();
			System.out.println(tmp.getClass().getName());
			SearchResult sr = (SearchResult) tmp;
			Attributes at = sr.getAttributes();
			System.out.println(at.get("cn"));
		}
		System.out.println("Done " + ne.hasMore());
		return ne.hasMore();
	}

	/**
	 * Modify the attribute in the ldap directory for the given string.
	 * 
	 * @param mods add all the entry in to the ModificationItem
	 * @param string the string (dn) value
	 */
	public void modifyTest(DirContext dirContext,ModificationItem[] mods, String string) throws NamingException {
		dirContext.modifyAttributes(string, mods);
	}

	/**
	 * Create the attribute in the ldap directory for the given string.
	 * 
	 * @param basicattributes add all the entry in to the basicattribute
	 * @param string the string (dn) value
	 */
	public void createTest(DirContext dirContext,BasicAttributes basicattributes, String string) throws NamingException {
		dirContext.createSubcontext(string, basicattributes);
	}
	
}
