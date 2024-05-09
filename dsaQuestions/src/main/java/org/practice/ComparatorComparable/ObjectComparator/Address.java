package org.practice.ComparatorComparable.ObjectComparator;

public class Address {
  int streetNo;
  String addressLine1;
  int pincode;

  @Override
  public String toString() {
    return "Address{"
        + "streetNo="
        + streetNo
        + ", addressLine1='"
        + addressLine1
        + '\''
        + ", pincode="
        + pincode
        + '}';
  }
}
