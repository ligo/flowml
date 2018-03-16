package com.beautiful.api.writable;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class WritableComparatorUtils {

    /**
     * 逐字节比较两组二进制数据.
     *
     * @param b1
     * @param s1
     * @param l1
     * @param b2
     * @param s2
     * @param l2
     * @return
     * @see RawComparator#compare(byte[], int, int, byte[], int, int)
     */
    public static int compareBytes(byte[] b1, int s1, int l1, byte[] b2, int s2,
                                   int l2) {
        int end1 = s1 + l1;
        int end2 = s2 + l2;
        for (int i = s1, j = s2; i < end1 && j < end2; i++, j++) {
            int a = (b1[i] & 0xff);
            int b = (b2[j] & 0xff);
            if (a != b) {
                return a - b;
            }
        }
        return l1 - l2;
    }

    /**
     * 计算二进制数据的哈希值.
     *
     * @param bytes
     *     byte数组
     * @param length
     *     数据长度
     * @return 哈希值
     */
    public static int hashBytes(byte[] bytes, int length) {
        int hash = 1;
        for (int i = 0; i < length; i++) {
            hash = (31 * hash) + (int) bytes[i];
        }
        return hash;
    }

    /**
     * 从 byte 数组读取无符号 short.
     *
     * @param bytes
     *     字节数组
     * @param start
     *     起始位置，读取内容bytes[start, start+1]
     * @return
     */
    public static int readUnsignedShort(byte[] bytes, int start) {
        return (((bytes[start] & 0xff) << 8) + ((bytes[start + 1] & 0xff)));
    }

    /**
     * 从 byte 数组读取 int.
     *
     * @param bytes
     *     字节数组
     * @param start
     *     起始位置，读取内容bytes[start, start+3]
     * @return
     */
    public static int readInt(byte[] bytes, int start) {
        return (((bytes[start] & 0xff) << 24) + ((bytes[start + 1] & 0xff) << 16)
                + ((bytes[start + 2] & 0xff) << 8) + ((bytes[start + 3] & 0xff)));

    }

    /**
     * 从 byte 数组读取 float.
     *
     * @param bytes
     *     字节数组
     * @param start
     *     起始位置，读取内容bytes[start, start+3]
     * @return
     */
    public static float readFloat(byte[] bytes, int start) {
        return Float.intBitsToFloat(readInt(bytes, start));
    }

    /**
     * 从 byte 数组读取 long.
     *
     * @param bytes
     *     字节数组
     * @param start
     *     起始位置，读取内容bytes[start, start+7]
     * @return
     */
    public static long readLong(byte[] bytes, int start) {
        return ((long) (readInt(bytes, start)) << 32)
                + (readInt(bytes, start + 4) & 0xFFFFFFFFL);
    }

    /**
     * 从 byte 数组读取double.
     *
     * @param bytes
     *     字节数组
     * @param start
     *     起始位置，读取内容bytes[start, start+7]
     * @return
     */
    public static double readDouble(byte[] bytes, int start) {
        return Double.longBitsToDouble(readLong(bytes, start));
    }

    /**
     * 从byte数组读取压缩编码过的 long.
     *
     * @param bytes
     *     字节数组
     * @param start
     *     起始位置，读取内容长度依 long 值的压缩编码特征而定
     * @return
     * @throws IOException
     */
    public static long readVLong(byte[] bytes, int start) throws IOException {
        int len = bytes[start];
        if (len >= -112) {
            return len;
        }
        boolean isNegative = (len < -120);
        len = isNegative ? -(len + 120) : -(len + 112);
        if (start + 1 + len > bytes.length) {
            throw new IOException(
                    "Not enough number of bytes for a zero-compressed integer");
        }
        long i = 0;
        for (int idx = 0; idx < len; idx++) {
            i = i << 8;
            i = i | (bytes[start + 1 + idx] & 0xFF);
        }
        return (isNegative ? (i ^ -1L) : i);
    }

    /**
     * 从byte数组读取压缩编码过的 int.
     *
     * @param bytes
     *     字节数组
     * @param start
     *     起始位置，读取内容长度依 int 值的压缩编码特征而定
     * @return
     * @throws IOException
     */
    public static int readVInt(byte[] bytes, int start) throws IOException {
        return (int) readVLong(bytes, start);
    }

    public static byte[] toByteArray(double[] doubleArray){
        int times = Double.SIZE / Byte.SIZE;
        byte[] bytes = new byte[doubleArray.length * times];
        for(int i=0;i<doubleArray.length;i++){
            ByteBuffer.wrap(bytes, i*times, times).putDouble(doubleArray[i]);
        }
        return bytes;
    }

    public static double[] toDoubleArray(byte[] byteArray){
        int times = Double.SIZE / Byte.SIZE;
        double[] doubles = new double[byteArray.length / times];
        for(int i=0;i<doubles.length;i++){
            doubles[i] = ByteBuffer.wrap(byteArray, i*times, times).getDouble();
        }
        return doubles;
    }



}
