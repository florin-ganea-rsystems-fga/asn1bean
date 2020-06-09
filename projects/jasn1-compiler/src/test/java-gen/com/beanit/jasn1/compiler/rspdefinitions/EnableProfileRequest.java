/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.rspdefinitions;

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

import com.beanit.jasn1.compiler.pkix1explicit88.Certificate;
import com.beanit.jasn1.compiler.pkix1explicit88.CertificateList;
import com.beanit.jasn1.compiler.pkix1explicit88.Time;
import com.beanit.jasn1.compiler.pkix1implicit88.SubjectKeyIdentifier;

public class EnableProfileRequest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class ProfileIdentifier implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		private byte[] code = null;
		public OctetTo16 isdpAid = null;
		public Iccid iccid = null;
		
		public ProfileIdentifier() {
		}

		public ProfileIdentifier(byte[] code) {
			this.code = code;
		}

		public ProfileIdentifier(OctetTo16 isdpAid, Iccid iccid) {
			this.isdpAid = isdpAid;
			this.iccid = iccid;
		}

		@Override public int encode(OutputStream reverseOS) throws IOException {

			if (code != null) {
				reverseOS.write(code);
				return code.length;
			}

			int codeLength = 0;
			if (iccid != null) {
				codeLength += iccid.encode(reverseOS, true);
				return codeLength;
			}
			
			if (isdpAid != null) {
				codeLength += isdpAid.encode(reverseOS, false);
				// write tag: APPLICATION_CLASS, PRIMITIVE, 15
				reverseOS.write(0x4F);
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

			if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
				isdpAid = new OctetTo16();
				tlvByteCount += isdpAid.decode(is, false);
				return tlvByteCount;
			}

			if (berTag.equals(Iccid.tag)) {
				iccid = new Iccid();
				tlvByteCount += iccid.decode(is, false);
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

			if (isdpAid != null) {
				sb.append("isdpAid: ").append(isdpAid);
				return;
			}

			if (iccid != null) {
				sb.append("iccid: ").append(iccid);
				return;
			}

			sb.append("<none>");
		}

	}

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 49);

	private byte[] code = null;
	public ProfileIdentifier profileIdentifier = null;
	public BerBoolean refreshFlag = null;
	
	public EnableProfileRequest() {
	}

	public EnableProfileRequest(byte[] code) {
		this.code = code;
	}

	public EnableProfileRequest(ProfileIdentifier profileIdentifier, BerBoolean refreshFlag) {
		this.profileIdentifier = profileIdentifier;
		this.refreshFlag = refreshFlag;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		int sublength;

		codeLength += refreshFlag.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		reverseOS.write(0x81);
		codeLength += 1;
		
		sublength = profileIdentifier.encode(reverseOS);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
		reverseOS.write(0xA0);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			vByteCount += length.decode(is);
			profileIdentifier = new ProfileIdentifier();
			vByteCount += profileIdentifier.decode(is, null);
			vByteCount += length.readEocIfIndefinite(is);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			refreshFlag = new BerBoolean();
			vByteCount += refreshFlag.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		}

		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);

	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (profileIdentifier != null) {
			sb.append("profileIdentifier: ");
			profileIdentifier.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("profileIdentifier: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (refreshFlag != null) {
			sb.append("refreshFlag: ").append(refreshFlag);
		}
		else {
			sb.append("refreshFlag: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

