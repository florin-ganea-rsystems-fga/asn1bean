/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pkix1implicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;

import com.beanit.jasn1.compiler.pkix1explicit88.Attribute;
import com.beanit.jasn1.compiler.pkix1explicit88.CertificateSerialNumber;
import com.beanit.jasn1.compiler.pkix1explicit88.DirectoryString;
import com.beanit.jasn1.compiler.pkix1explicit88.Name;
import com.beanit.jasn1.compiler.pkix1explicit88.ORAddress;
import com.beanit.jasn1.compiler.pkix1explicit88.RelativeDistinguishedName;

public class DistributionPointName implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	private byte[] code = null;
	public GeneralNames fullName = null;
	public RelativeDistinguishedName nameRelativeToCRLIssuer = null;
	
	public DistributionPointName() {
	}

	public DistributionPointName(byte[] code) {
		this.code = code;
	}

	public DistributionPointName(GeneralNames fullName, RelativeDistinguishedName nameRelativeToCRLIssuer) {
		this.fullName = fullName;
		this.nameRelativeToCRLIssuer = nameRelativeToCRLIssuer;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			return code.length;
		}

		int codeLength = 0;
		if (nameRelativeToCRLIssuer != null) {
			codeLength += nameRelativeToCRLIssuer.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
			reverseOS.write(0xA1);
			codeLength += 1;
			return codeLength;
		}
		
		if (fullName != null) {
			codeLength += fullName.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			reverseOS.write(0xA0);
			codeLength += 1;
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int tlvByteCount = 0;
		boolean tagWasPassed = (berTag != null);

		if (berTag == null) {
			berTag = new BerTag();
			tlvByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			fullName = new GeneralNames();
			tlvByteCount += fullName.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			nameRelativeToCRLIssuer = new RelativeDistinguishedName();
			tlvByteCount += nameRelativeToCRLIssuer.decode(is, false);
			return tlvByteCount;
		}

		if (tagWasPassed) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (fullName != null) {
			sb.append("fullName: ");
			fullName.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (nameRelativeToCRLIssuer != null) {
			sb.append("nameRelativeToCRLIssuer: ");
			nameRelativeToCRLIssuer.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

