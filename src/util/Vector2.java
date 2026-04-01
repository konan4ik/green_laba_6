package util;

public class Vector2 {
    private final double _x;
    private final double _y;

    public Vector2() {
        _x = 0;
        _y = 0;
    }
    public Vector2(double x, double y) {
        _x = x;
        _y = y;
    }

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(this._x + other._x, this._y + other._y);
    }

    public Vector2 sub(Vector2 other) {
        return new Vector2(this._x - other._x, this._y - other._y);
    }

    public Vector2 mul(double scalar) {
        return new Vector2(this._x * scalar, this._y * scalar);
    }

    public double dot(Vector2 other) {
        return this._x * other._x + this._y * other._y;
    }

    public double length() {
        return Math.sqrt(_x * _x + _y * _y);
    }

    public Vector2 normalize() {
        double len = length();
        if (len == 0) return new Vector2();
        return new Vector2(_x / len, _y / len);
    }

    public double distanceTo(Vector2 other) {
        return Math.sqrt(Math.pow(other._x - this._x, 2) + Math.pow(other._y - this._y, 2));
    }
}
