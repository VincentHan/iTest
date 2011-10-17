/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Documents and Settings\\krinviha\\workspace\\iTest\\src\\com\\hkmc\\smartusblauncher\\ISmartusbResourceService.aidl
 */
package com.hkmc.smartusblauncher;
/**
 * System private API for talking with the Smartusb Resource
 */
public interface ISmartusbResourceService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.hkmc.smartusblauncher.ISmartusbResourceService
{
private static final java.lang.String DESCRIPTOR = "com.hkmc.smartusblauncher.ISmartusbResourceService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.hkmc.smartusblauncher.ISmartusbResourceService interface,
 * generating a proxy if needed.
 */
public static com.hkmc.smartusblauncher.ISmartusbResourceService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.hkmc.smartusblauncher.ISmartusbResourceService))) {
return ((com.hkmc.smartusblauncher.ISmartusbResourceService)iin);
}
return new com.hkmc.smartusblauncher.ISmartusbResourceService.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setResourceRootPath:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setResourceRootPath(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getResourceString:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.getResourceString(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getResourceImage:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.graphics.Bitmap _result = this.getResourceImage(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getResourceData:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _result = this.getResourceData(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.hkmc.smartusblauncher.ISmartusbResourceService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * 리소스 파일의 root path 설정
     */
public void setResourceRootPath(java.lang.String path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
mRemote.transact(Stub.TRANSACTION_setResourceRootPath, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 문자열 얻어오기
     */
public java.lang.String getResourceString(int resID) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(resID);
mRemote.transact(Stub.TRANSACTION_getResourceString, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 Bitmap 이미지 객체 얻어오기
     */
public android.graphics.Bitmap getResourceImage(int resID) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.graphics.Bitmap _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(resID);
mRemote.transact(Stub.TRANSACTION_getResourceImage, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.graphics.Bitmap.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 바이너리 데이터 얻어오기
     */
public byte[] getResourceData(int resID) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(resID);
mRemote.transact(Stub.TRANSACTION_getResourceData, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_setResourceRootPath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getResourceString = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getResourceImage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getResourceData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
/**
     * 리소스 파일의 root path 설정
     */
public void setResourceRootPath(java.lang.String path) throws android.os.RemoteException;
/**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 문자열 얻어오기
     */
public java.lang.String getResourceString(int resID) throws android.os.RemoteException;
/**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 Bitmap 이미지 객체 얻어오기
     */
public android.graphics.Bitmap getResourceImage(int resID) throws android.os.RemoteException;
/**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 바이너리 데이터 얻어오기
     */
public byte[] getResourceData(int resID) throws android.os.RemoteException;
}
