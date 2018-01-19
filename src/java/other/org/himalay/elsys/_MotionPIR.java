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

@Created(date = "Sun Dec 10 01:12:59 EST 2017")

public class _MotionPIR extends ElsysDataFactory.ElsysData { // Concrete type is MotionPIR

	// members variables
	// header
	public LPPHeader header;
	// _value
	public short _value;
	// time
	

	public _MotionPIR() // throws Exception
	{
		init();
	}

	private void init() {
		// Initialize header
		header = new LPPHeader();
		// Initialize _value

		// Initialize time
		time = new ByteArray();
		time.setSizeType("EXTERNAL");
	}

	public int readNoHeader(DataInputStream istream) throws IOException {

		preRead();
		int retVal = 0;
		// read _value
		{
			_value = (short) (istream.readUnsignedByte());
			retVal += 1;
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
		// read _value
		{
			_value = (short) (istream.readUnsignedByte());
			retVal += 1;
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
		// write _value
		ostream.writeByte(_value);
		retVal += 1;
		// write time
		{
			retVal += time.write(ostream);
		}
		postWrite();
		return retVal;
	}

	public int dump(DumpContext dc) throws IOException {
		dc.indent();
		dc.getPs().print("_MotionPIR\n");
		dc.increaseIndent();
		int retVal = 0;
		// write header
		if (header != null) {
			dc.indent();
			dc.getPs().println("header");
			retVal += header.dump(dc);
		}
		// write _value
		dc.indent();
		dc.getPs().println("_value=" + _value + "(0x" + Integer.toHexString(_value) + ")");
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
	// Getter for _value
	// public short get_value()
	// {
	// return _value ;
	// }

	// Setter for _value
	// public void set_value(short val)
	// {
	// this._value= val;
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
		this.header.setMessageType(0x05);
	}

	public LPPHeader getHeader() {
		return this.header;
	}

}

// End of code