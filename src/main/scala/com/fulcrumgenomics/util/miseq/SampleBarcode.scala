/**
  * Copyright (c) 2016 Fulcrum Genomics LLC
  * All rights reserved.
  *
  * Redistribution and use in source and binary forms, with or without
  * modification, are permitted provided that the following conditions are met:
  *
  * 1. Redistributions of source code must retain the above copyright notice,
  * this list of conditions and the following disclaimer.
  *
  * 2. Redistributions in binary form must reproduce the above copyright notice,
  * this list of conditions and the following disclaimer in the documentation
  * and/or other materials provided with the distribution.
  *
  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
  * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
  * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
  * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
  * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
  * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
  * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
  * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
  * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  * POSSIBILITY OF SUCH DAMAGE.
  */

package com.fulcrumgenomics.util.miseq

object SampleBarcode {
  val SampleBarcodeDelimiter: String = "-"
}

/**
  * A little class to store the sample barcode as bytes and concatenated with `IlluminaUtil.barcodeSeqsToString`.
  */
class SampleBarcode(sampleBarcodes: Seq[String]) {
  import SampleBarcode.SampleBarcodeDelimiter

  val barcodeBytes: Array[Byte]   = sampleBarcodes.flatMap(_.getBytes).toArray
  val concatenatedBarcode: String = sampleBarcodes.filter(_.nonEmpty).mkString(SampleBarcodeDelimiter)

  override def equals(o: Any): Boolean = o.isInstanceOf[SampleBarcode] && this.concatenatedBarcode == o.asInstanceOf[SampleBarcode].concatenatedBarcode
  override def hashCode: Int = concatenatedBarcode.hashCode
  override def toString: String = concatenatedBarcode
}