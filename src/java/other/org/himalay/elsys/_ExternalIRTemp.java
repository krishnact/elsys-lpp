/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.elsys;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.himalay.msgs.runtime.Created;

import org.himalay.msgs.runtime.*;

@Created(date = "Sun Dec 10 01:13:00 EST 2017")

public class _ExternalIRTemp extends ElsysDataFactory.ElsysData { // Concrete type is ExternalIRTemp

	// members variables
	// header
	public LPPHeader header;
	// _value1
	public short _value1;
	// _value2
	public short _value2;
	// time
	

	public _ExternalIRTemp() // throws Exception
	{
		init();
	}

	private void init() {
		// Initialize header
		header = new LPPHeader();
		// Initialize _value1

		// Initialize _value2

		// Initialize time
		time = new ByteArray();
		time.setSizeType("EXTERNAL");
	}

	public int readNoHeader(DataInputStream istream) throws IOException {

		preRead();
		int retVal = 0;
		// read _value1
		{
			_value1 = istream.readShort();
			retVal += 2;
		}
		// read _value2
		{
			_value2 = istream.readShort();
			retVal += 2;
		}
		// read time
		{
			time.setSizeType("EXTERNAL");
			int iRead = getHeader().getNob() + (0);
			time.setSize(iRead);
			retVal += time.read(istream);
		}

		postRead();
		return retVal;
	}

	public int read(DataInputStream istream) throws IOException {
		preRead();
		int retVal = 0;

		// read header
		retVal += header.read(istream);
		// read _value1
		{
			_value1 = istream.readShort();
			retVal += 2;
		}
		// read _value2
		{
			_value2 = istream.readShort();
			retVal += 2;
		}
		// read time
		{
			time.setSizeType("EXTERNAL");
			int iRead = getHeader().getNob() + (0);
			time.setSize(iRead);
			retVal += time.read(istream);
		}

		postRead();
		return retVal;
	}

	public int write(DataOutputStream ostream) throws IOException {
		preWrite();
		int retVal = 0;

		{
			/** fix dependent sizes for header **/
		}

		{
			/** fix dependent sizes for time **/
			header.setNob((short) time.getSize() - (0));
		}

		// write header
		if (header != null)
			retVal += header.write(ostream);
		// write _value1
		ostream.writeShort(_value1);
		retVal += 2;
		// write _value2
		ostream.writeShort(_value2);
		retVal += 2;
		// write time
		{
			retVal += time.write(ostream);
		}
		postWrite();
		return retVal;
	}

	public int dump(DumpContext dc) throws IOException {
		dc.indent();
		dc.getPs().print("_ExternalIRTemp\n");
		dc.increaseIndent();
		int retVal = 0;
		// write header
		if (header != null) {
			dc.indent();
			dc.getPs().println("header");
			retVal += header.dump(dc);
		}
		// write _value1
		dc.indent();
		dc.getPs().println("_value1=" + _value1 + "(0x" + Integer.toHexString(_value1) + ")");
		// write _value2
		dc.indent();
		dc.getPs().println("_value2=" + _value2 + "(0x" + Integer.toHexString(_value2) + ")");
		// write time
		dc.indent();
		dc.getPs().print("time: " + time.getSize() + "(0x" + Integer.toHexString(time.getSize()) + ")\n");
		this.time.dump(dc);
		dc.decreaseIndent();
		return retVal;
	}

	// Getter for header
	// public LPPHeader getHeader()
	// {
	// return header ;
	// }

	// Setter for header
	// public void setHeader(LPPHeader val)
	// {
	// this.header= val;
	// }
	// Getter for _value1
	// public short get_value1()
	// {
	// return _value1 ;
	// }

	// Setter for _value1
	// public void set_value1(short val)
	// {
	// this._value1= val;
	// }
	// Getter for _value2
	// public short get_value2()
	// {
	// return _value2 ;
	// }

	// Setter for _value2
	// public void set_value2(short val)
	// {
	// this._value2= val;
	// }
	// Getter for time
	// public ByteArray getTime()
	// {
	// return time ;
	// }

	// Setter for time
	// public void setTime(ByteArray val)
	// {
	// this.time= val;
	// }

	public void setTime(byte[] val) {
		this.time.setData(val);
	}

	public int getSize() throws IOException {
		DataOutputStream dos = new DataOutputStream(new NullStream());
		return this.write(dos);
	}

	public void setHeader(LPPHeader header) {
		this.header = header;
		this.header.setMessageType(0x10);
	}

	public LPPHeader getHeader() {
		return this.header;
	}

}

// End of code