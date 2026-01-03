<?php

namespace App\Http\Controllers;

use App\Models\Costume;
use Illuminate\Http\Request;

class CostumeController extends Controller
{
    // List all costumes
    public function index()
    {
        return response()->json(Costume::all(), 200);
    }

    // Show single costume
    public function show($id)
    {
        $costume = Costume::find($id);
        if (!$costume) {
            return response()->json(['message' => 'Costume not found'], 404);
        }
        return response()->json($costume, 200);
    }

    // Admin: Add costume
    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required',
            'price' => 'required',
            'image_url' => 'required'
        ]);

        $costume = Costume::create($request->all());
        return response()->json($costume, 201);
    }
}
