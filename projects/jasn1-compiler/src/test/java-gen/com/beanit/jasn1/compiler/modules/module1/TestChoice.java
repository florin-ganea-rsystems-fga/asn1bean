/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.modules.module1;

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

import com.beanit.jasn1.compiler.modules.module2.EmployeeNumberZ;
import com.beanit.jasn1.compiler.modules.module3.Datezz;
import com.beanit.jasn1.compiler.modules.module3.EmployeeNumberzz;

public class TestChoice implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	private byte[] code = null;
	private ChildInformation choiceElement1 = null;
	private ChildInformation3 choiceElement2 = null;
	
	public TestChoice() {
	}

	public TestChoice(byte[] code) {
		this.code = code;
	}

	public void setChoiceElement1(ChildInformation choiceElement1) {
		this.choiceElement1 = choiceElement1;
	}

	public ChildInformation getChoiceElement1() {
		return choiceElement1;
	}

	public void setChoiceElement2(ChildInformation3 choiceElement2) {
		this.choiceElement2 = choiceElement2;
	}

	public ChildInformation3 getChoiceElement2() {
		return choiceElement2;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			return code.length;
		}

		int codeLength = 0;
		if (choiceElement2 != null) {
			codeLength += choiceElement2.encode(reverseOS, true);
			return codeLength;
		}
		
		if (choiceElement1 != null) {
			codeLength += choiceElement1.encode(reverseOS, true);
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

		if (berTag.equals(ChildInformation.tag)) {
			choiceElement1 = new ChildInformation();
			tlvByteCount += choiceElement1.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(ChildInformation3.tag)) {
			choiceElement2 = new ChildInformation3();
			tlvByteCount += choiceElement2.decode(is, false);
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

		if (choiceElement1 != null) {
			sb.append("choiceElement1: ");
			choiceElement1.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (choiceElement2 != null) {
			sb.append("choiceElement2: ");
			choiceElement2.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

