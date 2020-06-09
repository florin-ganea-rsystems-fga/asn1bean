/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.information_objects;

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


public class Item implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	private byte[] code = null;
	private BerInteger itemCode = null;
	private BerVisibleString itemDescription = null;
	private BerAny feature = null;
	private BerInteger quantity = null;
	private BerReal unitPrice = null;
	private BerReal itemTotal = null;
	private BerBoolean isTaxable = null;
	
	public Item() {
	}

	public Item(byte[] code) {
		this.code = code;
	}

	public void setItemCode(BerInteger itemCode) {
		this.itemCode = itemCode;
	}

	public BerInteger getItemCode() {
		return itemCode;
	}

	public void setItemDescription(BerVisibleString itemDescription) {
		this.itemDescription = itemDescription;
	}

	public BerVisibleString getItemDescription() {
		return itemDescription;
	}

	public void setFeature(BerAny feature) {
		this.feature = feature;
	}

	public BerAny getFeature() {
		return feature;
	}

	public void setQuantity(BerInteger quantity) {
		this.quantity = quantity;
	}

	public BerInteger getQuantity() {
		return quantity;
	}

	public void setUnitPrice(BerReal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BerReal getUnitPrice() {
		return unitPrice;
	}

	public void setItemTotal(BerReal itemTotal) {
		this.itemTotal = itemTotal;
	}

	public BerReal getItemTotal() {
		return itemTotal;
	}

	public void setIsTaxable(BerBoolean isTaxable) {
		this.isTaxable = isTaxable;
	}

	public BerBoolean getIsTaxable() {
		return isTaxable;
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
		codeLength += isTaxable.encode(reverseOS, true);
		
		codeLength += itemTotal.encode(reverseOS, true);
		
		codeLength += unitPrice.encode(reverseOS, true);
		
		codeLength += quantity.encode(reverseOS, true);
		
		codeLength += feature.encode(reverseOS);
		
		codeLength += itemDescription.encode(reverseOS, true);
		
		codeLength += itemCode.encode(reverseOS, true);
		
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
		int numDecodedBytes;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerInteger.tag)) {
			itemCode = new BerInteger();
			vByteCount += itemCode.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerVisibleString.tag)) {
			itemDescription = new BerVisibleString();
			vByteCount += itemDescription.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		feature = new BerAny();
		numDecodedBytes = feature.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (berTag.equals(BerInteger.tag)) {
			quantity = new BerInteger();
			vByteCount += quantity.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerReal.tag)) {
			unitPrice = new BerReal();
			vByteCount += unitPrice.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerReal.tag)) {
			itemTotal = new BerReal();
			vByteCount += itemTotal.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerBoolean.tag)) {
			isTaxable = new BerBoolean();
			vByteCount += isTaxable.decode(is, false);
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
		if (itemCode != null) {
			sb.append("itemCode: ").append(itemCode);
		}
		else {
			sb.append("itemCode: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (itemDescription != null) {
			sb.append("itemDescription: ").append(itemDescription);
		}
		else {
			sb.append("itemDescription: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (feature != null) {
			sb.append("feature: ").append(feature);
		}
		else {
			sb.append("feature: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (quantity != null) {
			sb.append("quantity: ").append(quantity);
		}
		else {
			sb.append("quantity: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (unitPrice != null) {
			sb.append("unitPrice: ").append(unitPrice);
		}
		else {
			sb.append("unitPrice: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (itemTotal != null) {
			sb.append("itemTotal: ").append(itemTotal);
		}
		else {
			sb.append("itemTotal: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (isTaxable != null) {
			sb.append("isTaxable: ").append(isTaxable);
		}
		else {
			sb.append("isTaxable: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

