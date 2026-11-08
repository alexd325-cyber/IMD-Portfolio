using UnityEngine;

public class Throw : Interaction
{
    public float force = 10;

    Rigidbody rb;
    void Start()
    {
        rb = transform.parent.GetComponent<Rigidbody>();
    }
    protected override void SelectExit()
    {
        rb.AddForce(force * Camera.main.transform.forward, ForceMode.Impulse);
    }
}
