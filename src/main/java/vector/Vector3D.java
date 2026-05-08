package vector;

/**
 * This class represents a 3D vector.
 */
public class Vector3D {
  private double xval;
  private double yval;
  private double zval;

  /**
   * Constructs a 3 dimensional vector using 3 parameters.
   *
   * @param xval the x component of the vector
   * @param yval the y component of the  vector
   * @param zval the z component of the vector
   */
  public Vector3D(double xval, double yval, double zval) {
    this.xval = xval;
    this.yval = yval;
    this.zval = zval;
  }

  public double getX() {
    return xval;
  }

  public double getY() {
    return yval;
  }

  public double getZ() {
    return zval;
  }

  public double getMagnitude() {
    return 0;
  }

  /**
   * Computes the angle between two vectors.
   *
   * @param other the other vector compute the angle between
   *
   * @return the angle between the two vectros.
   */
  public double angleBetween(Vector3D other) throws IllegalStateException{
    if ( other.getMagnitude() == 0 ){
      throw new IllegalStateException("Cannot compute angle with another vector of 0 magnitude.");
    }
    return 0;
  }

  /**
   * Divides each component of the vector by its magnitude producing a unit vector.
   *
   * @return a normalized version of this vector.
   */
  public Vector3D normalize() throws IllegalStateException{
    if ( this.getMagnitude() == 0 ){
      throw new IllegalStateException("Cannot compute normalize with 0 magnitude.");
    }
    return new Vector3D(1, 1, 1);
  }

  /**
   * Produces a new vector whose xval,yval,zval components are the sum of the individual
   * corresponding parts.
   *
   * @param otherVector the other vector to be used for addition.
   * @return the resulting sum vector between this vector and @param otherVector.
   */
  public Vector3D add(Vector3D otherVector) {
    return new Vector3D(this.xval + otherVector.getX(),
                        this.yval + otherVector.getY(),
                          this.zval + otherVector.getZ());
  }

  /**
   * Computes the dot prodcut. Expalin what the dot product is.
   *
   * @param other the other vector for the other product.
   * @return the resulting dot product value.
   */
  public double dotProduct(Vector3D other) {
    return 0;
  }

  /**
   * Multiplies each component by the scalar value.
   *
   * @param scalar the scalar value to be used.
   *
   * @return a new vector, finish here.
   */
  public Vector3D multiply(double scalar) {
    return new Vector3D(this.xval * scalar, this.yval * scalar, this.zval * scalar);
  }
}