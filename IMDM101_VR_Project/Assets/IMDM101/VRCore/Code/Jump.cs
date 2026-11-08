using UnityEngine;

public class Jump : Interaction
{
    public float force = 5;
    Rigidbody rb;
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        rb = GetComponent<Rigidbody>();
    }

    protected override void Activate()
    {
        rb.AddForce(force * Vector3.up, ForceMode.Impulse);
    }
}
