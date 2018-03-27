package com.beautiful.api.metadata

import com.beautiful.api.schema.ColumnType
import org.apache.spark.ml.linalg.SQLDataTypes
import org.apache.spark.sql.types.{DataType, DataTypes, StructField}



/**
  *
  * 扩展一些Value 方便像原生类型直接操作 todo add api
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/26 下午10:13
  *
  **/
object ColumnMetaDatas {

  def toStructField[T <: ColumnMetaData](x: T): StructField = {
    x.columnType match {
      case ColumnType.STRING => DataTypes.createStructField(x.name, toDataType(ColumnType.STRING), true)
      case ColumnType.INTEGER => DataTypes.createStructField(x.name, toDataType(ColumnType.INTEGER), true)
      case ColumnType.LONG => DataTypes.createStructField(x.name, toDataType(ColumnType.LONG), true)
      case ColumnType.DOUBLE => DataTypes.createStructField(x.name, toDataType(ColumnType.DOUBLE), true)
      case ColumnType.FLOAT => DataTypes.createStructField(x.name, toDataType(ColumnType.FLOAT), true)
      case ColumnType.DECIMAL => DataTypes.createStructField(x.name, toDataType(ColumnType.DECIMAL), true)
      case ColumnType.TIMESTAMP => DataTypes.createStructField(x.name, toDataType(ColumnType.TIMESTAMP), true)
      case ColumnType.DATE => DataTypes.createStructField(x.name, toDataType(ColumnType.DATE), true)
      case ColumnType.VECTOR => DataTypes.createStructField(x.name, toDataType(ColumnType.VECTOR), true)
      case ColumnType.MATRIX => DataTypes.createStructField(x.name, toDataType(ColumnType.MATRIX), true)
      case ColumnType.ARRAY => DataTypes.createStructField(x.name, DataTypes.createArrayType(toDataType(x.asInstanceOf[ArrayMetaData].eleColumnType)), true)
      case ColumnType.MAP => DataTypes.createStructField(x.name, DataTypes.createMapType(toDataType(x.asInstanceOf[MapMetaData].keyColumnType), toDataType(x.asInstanceOf[MapMetaData].valColumnType)), true)
      case ColumnType.STRUCT => DataTypes.createStructField(x.name, DataTypes.createStructType(x.asInstanceOf[StructMetaData].eles.map(toStructField).toArray), true)
      case _ => throw new IllegalArgumentException(s"参数错误${x}")
    }
  }

  def toDataType(columnType: ColumnType): DataType = {
    columnType match {
      case ColumnType.STRING => DataTypes.StringType
      case ColumnType.INTEGER => DataTypes.IntegerType
      case ColumnType.LONG => DataTypes.LongType
      case ColumnType.DOUBLE => DataTypes.DoubleType
      case ColumnType.FLOAT => DataTypes.FloatType
      case ColumnType.DECIMAL => DataTypes.createDecimalType()
      case ColumnType.TIMESTAMP => DataTypes.TimestampType
      case ColumnType.DATE => DataTypes.DateType
      case ColumnType.VECTOR => SQLDataTypes.VectorType
      case ColumnType.MATRIX => SQLDataTypes.MatrixType
      case _ => throw new IllegalArgumentException(s"参数错误${columnType}")
    }

  }









}
